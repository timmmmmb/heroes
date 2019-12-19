package ch.bfh.tom.promoter.client.impl;

import ch.bfh.tom.promoter.client.ArenaClient;
import ch.bfh.tom.promoter.model.Party;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArenaClientFallback implements ArenaClient {
    @Override
    public String battle(List<Party> challangers) {
        return "No fight today";
    }
}
