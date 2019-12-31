package ch.bfh.tom.frontend.service;

import ch.bfh.tom.frontend.model.Party;

public interface FrontendService {

    String promoteFight();
    Party createParty(String name);
}
