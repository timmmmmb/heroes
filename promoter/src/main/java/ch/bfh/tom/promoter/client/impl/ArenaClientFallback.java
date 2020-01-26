package ch.bfh.tom.promoter.client.impl;

import ch.bfh.tom.promoter.client.ArenaClient;
import ch.bfh.tom.promoter.model.Battle;
import ch.bfh.tom.promoter.model.Camp;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArenaClientFallback implements ArenaClient {
    @Override
    public Battle battle(List<Camp> challangers) {
        Battle battle = new Battle();
        battle.setResult("No fight today");
        return battle;
    }
}
