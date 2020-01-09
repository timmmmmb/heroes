package ch.bfh.tom.promoter.controller;

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
        String result = promoterService.promoteFight(campID);
        return "The Promoter is proud to proclaim the following result of today's battle: "+result;
    }
}
