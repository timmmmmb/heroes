package ch.bfh.tom.promoter.service.impl;

import ch.bfh.tom.promoter.client.ArenaClient;
import ch.bfh.tom.promoter.client.CampClient;
import ch.bfh.tom.promoter.model.Party;
import ch.bfh.tom.promoter.service.PromoterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultPromoterService implements PromoterService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultPromoterService.class);

    @Autowired
    private CampClient campClient;

    @Autowired
    private ArenaClient arenaClient;

    @Override
    public String promoteFight(String campID) {
        Party challenger = campClient.getCamp(campID).getParty();
        Party challengee = campClient.getOpponent(campID).getParty();
        LOG.info("Todays battle is between Party '"+challengee.getName()+"' and Party '"+challenger.getName()+"'.");

        List<Party> challangers = new ArrayList<>();
        challangers.add(challengee);
        challangers.add(challenger);
        String winner = arenaClient.battle(challangers);
        LOG.info("And the winner is: Party '"+winner+"'");

        return  winner;
    }
}
