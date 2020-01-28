package ch.bfh.tom.promoter.controller;

import ch.bfh.tom.promoter.model.Battle;
import ch.bfh.tom.promoter.model.Camp;
import ch.bfh.tom.promoter.model.Party;
import ch.bfh.tom.promoter.service.PromoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromoterController {

    @Autowired
    private PromoterService promoterService;

    @GetMapping(value = "/promoteFight")
    public String promoteFight(@RequestParam String campID) {
        Battle battle = promoterService.promoteFight(campID);
        //save the battle in the history service
        Camp winner = promoterService.rewardCamp(battle);

        return "The Promoter is proud to proclaim the following result of today's battle: "+battle.getResult();
    }
}
