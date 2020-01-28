package ch.bfh.tom.history;

import ch.bfh.tom.history.model.ItemType;
import ch.bfh.tom.history.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ShopApplicationRunner implements ApplicationRunner {

    private ShopService shopService;

    @Autowired
    public void context(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        shopService.createItem("Health +10", 10, ItemType.HEALTH);
        shopService.createItem("Health +20", 20, ItemType.HEALTH);
        shopService.createItem("Health +50", 50, ItemType.HEALTH);
        shopService.createItem("Health Full", 100, ItemType.HEALTH);

        shopService.createItem("Defense +10", 10, ItemType.DEFENSE);
        shopService.createItem("Defense +20", 20, ItemType.DEFENSE);
        shopService.createItem("Defense +30", 30, ItemType.DEFENSE);

        shopService.createItem("Attack +10", 10, ItemType.ATTACK);
        shopService.createItem("Attack +20", 20, ItemType.ATTACK);
        shopService.createItem("Attack +30", 30, ItemType.ATTACK);

        shopService.createItem("GOD", 10000, ItemType.GOD);
    }
}
