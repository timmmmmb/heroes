package ch.bfh.tom.history.service.impl;

import ch.bfh.tom.history.model.Item;
import ch.bfh.tom.history.model.ItemType;
import ch.bfh.tom.history.repository.ItemRepository;
import ch.bfh.tom.history.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultShopService implements ShopService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(String name, double price, ItemType itemType) {

        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setItemType(itemType);

        System.out.println("Created new shop item ...");
        System.out.println("Name:   "+item.getName());
        System.out.println("Price:  "+item.getPrice());
        System.out.println("Type:  "+item.getItemType().toString());
        System.out.println();

        String id = itemRepository.save(item).getId();
        return itemRepository.findById(id).get();
    }
}
