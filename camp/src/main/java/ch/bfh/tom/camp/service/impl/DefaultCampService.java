package ch.bfh.tom.camp.service.impl;

import ch.bfh.tom.camp.model.Camp;
import ch.bfh.tom.camp.model.Hero;
import ch.bfh.tom.camp.model.Party;
import ch.bfh.tom.camp.repository.CampRepository;
import ch.bfh.tom.camp.service.CampService;
import ch.bfh.tom.camp.service.HeroService;
import ch.bfh.tom.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.stereotype.Service;

@Service
public class DefaultCampService implements CampService {

    @Autowired
    private PartyService partyService;
    @Autowired
    private HeroService heroService;
    @Autowired
    private CampRepository campRepository;
    @Autowired
    private RepositoryEntityLinks repositoryEntityLinks;

    @Override
    public Camp createCamp(String name) {
        Camp camp = new Camp();
        Party party = partyService.createParty(name);
        camp.addHeroes(party.getMembers());
        camp.setParty(party);
        camp.setName(name);
        camp.setGold(50);
        campRepository.save(camp);
        return camp;
    }

    @Override
    public Camp addHero(String name, String campID) {
        Camp camp = campRepository.findById(campID).get();
        double heroPrice = camp.getHeroes().iterator().next().getPrice();
        if(camp.getGold() >= heroPrice) {
            Hero hero = heroService.createHero(name);
            camp.addHeroe(hero);
            camp.add(repositoryEntityLinks.linkToItemResource(Hero.class, hero.getId()).withRel("hero" + hero.getId()));
            camp.setGold(camp.getGold() - heroPrice);
            camp = campRepository.save(camp);
        }
        return camp;
    }
}
