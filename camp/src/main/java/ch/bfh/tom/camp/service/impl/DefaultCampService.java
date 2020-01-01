package ch.bfh.tom.camp.service.impl;

import ch.bfh.tom.camp.model.Camp;
import ch.bfh.tom.camp.model.Party;
import ch.bfh.tom.camp.service.CampService;
import ch.bfh.tom.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultCampService implements CampService {

    @Autowired
    private PartyService partyService;

    @Override
    public Camp createCamp(String name) {
        Camp camp = new Camp();
        Party party = partyService.createParty(name);
        camp.setHeroes(party.getMembers());
        camp.setParty(party);
        camp.setName(name);
        return camp;
    }
}
