package ch.bfh.tom.frontend.service;

import ch.bfh.tom.frontend.model.Camp;
import ch.bfh.tom.frontend.model.Party;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

public interface FrontendService {

    String promoteFight(String campID);
    Party createParty(String name);
    Camp createCamp(String name);
    Camp[] getCamps();
    Camp getCamp(String id);
    Camp addHero(String heroName, String campID);
    Camp removeHeroFromParty(String heroID, String campID);
    Camp addHeroToParty(String heroID, String campID);
    byte[] getHeroImage(String heroID);
}
