package ch.bfh.tom.frontend.service.impl;

import ch.bfh.tom.frontend.client.CampClient;
import ch.bfh.tom.frontend.client.PromoterClient;
import ch.bfh.tom.frontend.model.Camp;
import ch.bfh.tom.frontend.model.Party;
import ch.bfh.tom.frontend.service.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultFrontendService implements FrontendService {


    @Autowired
    private PromoterClient promoterClient;

    @Autowired
    private CampClient campClient;

    @Override
    public String promoteFight(String campID) {
        return promoterClient.promoteFight(campID);
    }

    @Override
    public Party createParty(String name) {
        return campClient.createParty(name).getContent();
    }

    @Override
    public Camp createCamp(String name) {
        return campClient.createCamp(name).getContent();
    }

    @Override
    public Camp[] getCamps() {
        return campClient.listCamps();
    }

    @Override
    public Camp getCamp(String id) {
        return campClient.getCamp(id);
    }


    @Override
    public Camp addHero(String heroName, String campID){
        return campClient.addHero(heroName, campID).getContent();
    }

    @Override
    public Camp removeHeroFromParty(String heroID, String id) {
        return campClient.removeHeroFromParty(heroID, id).getContent();
    }

    @Override
    public Camp addHeroToParty(String heroID, String campID) {
        return campClient.addHeroToParty(heroID, campID).getContent();
    }
}
