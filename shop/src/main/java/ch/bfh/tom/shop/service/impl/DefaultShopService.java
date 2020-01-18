package ch.bfh.tom.shop.service.impl;

import ch.bfh.tom.shop.model.Hero;
import ch.bfh.tom.shop.model.Item;
import ch.bfh.tom.shop.model.ItemType;
import ch.bfh.tom.shop.repository.HeroRepository;
import ch.bfh.tom.shop.repository.ItemRepository;
import ch.bfh.tom.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultShopService implements ShopService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private HeroRepository heroRepository;

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

    @Override
    public Hero applyItem(String heroID, String itemID) {

        Item item = itemRepository.findById(itemID).get();
        Hero hero = heroRepository.findById(heroID).get();

        double heroGold = hero.getGold();
        double itemPrice = item.getPrice();
        if(heroGold >= itemPrice) {
            hero.setGold(heroGold - itemPrice);
        }

        return hero;
    }
}
