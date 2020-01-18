package ch.bfh.tom.shop.service;

import ch.bfh.tom.shop.model.Hero;
import ch.bfh.tom.shop.model.Item;
import ch.bfh.tom.shop.model.ItemType;

public interface ShopService {

    Item createItem(String name, double price, ItemType itemType);
    Hero applyItem(String heroID, String itemID);
}
