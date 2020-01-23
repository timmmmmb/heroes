package ch.bfh.tom.camp.service.impl;

import ch.bfh.tom.camp.model.Camp;
import ch.bfh.tom.camp.model.Party;
import ch.bfh.tom.camp.repository.CampRepository;
import ch.bfh.tom.camp.repository.PartyRepository;
import ch.bfh.tom.camp.service.CampService;
import ch.bfh.tom.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCampService implements CampService {

    @Autowired
    private PartyService partyService;
    @Autowired
    private CampRepository campRepository;

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
}
