package ch.bfh.tom.camp.service;

import ch.bfh.tom.camp.model.Hero;

public interface HeroService {

    Hero createHero(String name);
    Hero applyShopItem(String id, String itemType, double itemPrice);
}
