package ch.bfh.tom.history.controller;

import ch.bfh.tom.history.model.Battle;
import ch.bfh.tom.history.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private BattleRepository battleRepository;

    @GetMapping
    public @ResponseBody
    Battle[] list() {
        ArrayList<Battle> camps = (ArrayList<Battle>) battleRepository.findAll();
        return camps.toArray(new Battle[0]);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Battle battle) {
        battleRepository.save(battle);
    }

}
