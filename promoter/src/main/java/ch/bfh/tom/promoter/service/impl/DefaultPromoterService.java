package ch.bfh.tom.promoter.service.impl;

import ch.bfh.tom.promoter.client.ArenaClient;
import ch.bfh.tom.promoter.client.CampClient;
import ch.bfh.tom.promoter.client.HistoryClient;
import ch.bfh.tom.promoter.model.Battle;
import ch.bfh.tom.promoter.model.Camp;
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

    @Autowired
    private HistoryClient historyClient;

    @Override
    public Battle promoteFight(String campID) {
        Camp challenger = campClient.getCamp(campID);
        Camp challengee = campClient.getOpponent(campID);
        LOG.info("Todays battle is between Party '"+challengee.getParty().getName()+"' and Party '"+challenger.getParty().getName()+"'.");

        List<Camp> challangers = new ArrayList<>();
        challangers.add(challengee);
        challangers.add(challenger);
        Battle battle = arenaClient.battle(challangers);
        LOG.info("Result of the battle: '"+battle.getResult()+"'");

        return battle;
    }

    @Override
    public Camp rewardCamp(Battle battle) {
        Camp winner = battle.getWinner();
        if (winner == null) {
            return null;
        }
        return campClient.rewardCamp(winner.getId());
    }

    @Override
    public Camp updateXp(Battle battle) {
        Camp winner = battle.getWinner();
        if (winner == null) {
            return null;
        }
        return campClient.addXpToCamp(winner.getId());
    }

    @Override
    public void saveBattle(Battle battle) {
        historyClient.saveBattle(battle);
    }
}
