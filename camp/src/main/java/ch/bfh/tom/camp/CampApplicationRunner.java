package ch.bfh.tom.camp;

import ch.bfh.tom.camp.service.CampService;
import ch.bfh.tom.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CampApplicationRunner implements ApplicationRunner {

    private CampService campService;

    @Autowired
    public void context(CampService campService) {
        this.campService = campService;
    }

    @Override
    public void run(ApplicationArguments args) {
        campService.createCamp("Team Tom");
        campService.createCamp("Tom Team");
    }
}
