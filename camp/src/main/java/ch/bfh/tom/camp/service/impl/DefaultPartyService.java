package ch.bfh.tom.camp.service.impl;

import ch.bfh.tom.camp.model.Party;
import ch.bfh.tom.camp.repository.PartyRepository;
import ch.bfh.tom.camp.service.HeroService;
import ch.bfh.tom.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class DefaultPartyService implements PartyService {

    @Autowired
    private HeroService heroService;
    @Autowired
    private PartyRepository partyRepository;

    public Party createParty(String name) {
        Party party = new Party();

        party.setName(name);

        party.setMembers(new HashSet<>(Arrays.asList(
                heroService.createHero("Tom"),
                heroService.createHero("Yannick"),
                heroService.createHero("Tim"),
                heroService.createHero("Michael"))));

        System.out.println("Created new party ...");
        System.out.println("Name: " + party.getName());
        partyRepository.save(party);
        return party;
    }
}
