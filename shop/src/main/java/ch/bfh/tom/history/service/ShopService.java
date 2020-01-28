package ch.bfh.tom.history.service;

import ch.bfh.tom.history.model.Item;
import ch.bfh.tom.history.model.ItemType;

public interface ShopService {

    Item createItem(String name, double price, ItemType itemType);
}
