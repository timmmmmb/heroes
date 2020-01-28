package ch.bfh.tom.history.controller;

import ch.bfh.tom.history.model.Battle;
import ch.bfh.tom.history.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HistoryController {

    @Autowired
    private BattleRepository battleRepository;

    @GetMapping
    public @ResponseBody
    Battle[] list(@RequestParam String campID) {
        ArrayList<Battle> camps = (ArrayList<Battle>) battleRepository.findAll();
        ArrayList<Battle> battles = new ArrayList<>();
        for(Battle b:camps){
            if(b.getChallenger().getId().equals(campID)){
                battles.add(b);
            }
        }
        return battles.toArray(new Battle[0]);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Battle save(@RequestBody Battle battle) {
        return battleRepository.save(battle);
    }

}
