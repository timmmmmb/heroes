package ch.bfh.tom.promoter.client.impl;

import ch.bfh.tom.promoter.client.HistoryClient;
import ch.bfh.tom.promoter.model.Battle;
import org.springframework.stereotype.Component;

@Component
public class HistoryClientFallback implements HistoryClient {
    @Override
    public void saveBattle(Battle battle) {
        System.out.println("Using Fallback");
    }
}
