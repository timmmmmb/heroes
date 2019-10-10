package ch.bfh.tom.camp.impl;

import ch.bfh.tom.camp.model.Party;
import ch.bfh.tom.camp.service.HeroService;
import ch.bfh.tom.camp.service.PartyService;

import java.util.Arrays;

public class PartyServiceImpl implements PartyService {

    private HeroService heroService;

    public PartyServiceImpl(HeroService heroService) {
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
