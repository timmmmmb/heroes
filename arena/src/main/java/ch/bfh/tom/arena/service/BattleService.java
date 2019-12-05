package ch.bfh.tom.arena.service;

import ch.bfh.tom.arena.model.Party;

public interface BattleService {
    String battle(Party challengeeParty, Party challengerParty);
}
