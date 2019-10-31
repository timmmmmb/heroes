package ch.bfh.tom.camp.service.impl;

import ch.bfh.tom.camp.model.Party;
import ch.bfh.tom.camp.service.HeroService;
import ch.bfh.tom.camp.service.PartyService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DefaultPartyService implements PartyService {

    private HeroService heroService;

    public DefaultPartyService(HeroService heroService) {
        this.heroService = heroService;
    }

    public Party createParty(String name) {
        Party party = new Party();

        party.setName(name);
        party.setMembers(Arrays.asList(
                heroService.createHero("Tom"),
                heroService.createHero("Yannick"),
                heroService.createHero("Tim"),
                heroService.createHero("Michael")
        ));

        System.out.println("Created new party ...");
        System.out.println("Name: " + party.getName());

        return party;
    }
}
