package ch.bfh.tom.arena.controller;

import ch.bfh.tom.arena.model.Battle;
import ch.bfh.tom.arena.model.Camp;
import ch.bfh.tom.arena.model.Party;
import ch.bfh.tom.arena.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArenaController {

    @Autowired
    private BattleService battleService;

    @PostMapping(value = "/battle")
    public Battle battle(@RequestBody List<Camp> challengers) {

        if (challengers.size() != 2) {
            throw new RuntimeException("Only 2 challengers at the same time are allowed in the arena.");
        }

        Camp challengee = challengers.get(0);
        Camp challenger = challengers.get(1);
        return battleService.battle(challengee, challenger);
    }
}
