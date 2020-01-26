package ch.bfh.tom.camp.service;

import ch.bfh.tom.camp.model.Camp;

public interface CampService {

    Camp createCamp(String name);
    Camp addHero(String name, String campID);
}
