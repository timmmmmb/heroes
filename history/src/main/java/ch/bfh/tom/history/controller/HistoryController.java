package ch.bfh.tom.history.controller;

import ch.bfh.tom.history.model.Battle;
import ch.bfh.tom.history.model.History;
import ch.bfh.tom.history.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HistoryController {

    @Autowired
    private HistoryRepository battleRepository;

    @GetMapping
    public @ResponseBody
    History[] list(@RequestParam String campID) {
        ArrayList<History> camps = (ArrayList<History>) battleRepository.findAll();
        ArrayList<History> battles = new ArrayList<>();
        for(History b:camps){
            if(b.getChallengerID().equals(campID)){
                battles.add(b);
            }
        }
        return battles.toArray(new History[0]);
    }

    @PostMapping
    public void save(@RequestBody Battle b) {
        History h = new History(b.getChallenger().getId(), b.getChallengee().getId(), b.getWinner().getId(), b.getResult());
        battleRepository.save(h);
    }


}
