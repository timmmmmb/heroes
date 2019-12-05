package ch.bfh.tom.promoter.client;

import ch.bfh.tom.promoter.model.Party;

import java.util.List;

public interface ArenaClient {

    String battle(List<Party> challangers);
}
