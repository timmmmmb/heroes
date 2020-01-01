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
    public String promoteFight() {
        return promoterClient.promoteFight();
    }

    @Override
    public Party createParty(String name) {
        return campClient.createParty(name).getContent();
    }

    @Override
    public Camp[] getCamps() {
        return campClient.listCamps().getContent();
    }
}