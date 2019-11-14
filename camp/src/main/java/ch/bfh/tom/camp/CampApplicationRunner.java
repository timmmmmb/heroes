package ch.bfh.tom.camp;

import ch.bfh.tom.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CampApplicationRunner implements ApplicationRunner {

    private PartyService partyService;

    @Autowired
    public void context(PartyService partyService) {
        this.partyService = partyService;
    }

    @Override
    public void run(ApplicationArguments args) {
        partyService.createParty("Team Tom");
    }
}
