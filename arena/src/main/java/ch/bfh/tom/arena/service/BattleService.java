package ch.bfh.tom.arena.service;

import ch.bfh.tom.arena.model.Battle;
import ch.bfh.tom.arena.model.Camp;

public interface BattleService {
    Battle battle(Camp challengeeParty, Camp challengerParty);
}
