package ch.bfh.tom.frontend.service;

import ch.bfh.tom.frontend.model.Camp;
import ch.bfh.tom.frontend.model.Party;

import java.util.Collection;

public interface FrontendService {

    String promoteFight();
    Party createParty(String name);
    Camp[] getCamps();
}