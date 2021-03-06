package ch.bfh.tom.frontend.service.impl;

import ch.bfh.tom.frontend.client.CampClient;
import ch.bfh.tom.frontend.client.HistoryClient;
import ch.bfh.tom.frontend.client.PromoterClient;
import ch.bfh.tom.frontend.client.ShopClient;
import ch.bfh.tom.frontend.model.Camp;
import ch.bfh.tom.frontend.model.Hero;
import ch.bfh.tom.frontend.model.History;
import ch.bfh.tom.frontend.model.Item;
import ch.bfh.tom.frontend.model.Party;
import ch.bfh.tom.frontend.service.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class DefaultFrontendService implements FrontendService {


    @Autowired
    private PromoterClient promoterClient;

    @Autowired
    private CampClient campClient;

    @Autowired
    private HistoryClient historyClient;

    @Autowired
    private ShopClient shopClient;

    @Override
    public String promoteFight(String campID) {
        return promoterClient.promoteFight(campID);
    }

    @Override
    public Party createParty(String name) {
        return campClient.createParty(name).getContent();
    }

    @Override
    public Camp createCamp(String name) {
        return campClient.createCamp(name).getContent();
    }

    @Override
    public Camp[] getCamps() {
        return campClient.listCamps();
    }

    @Override
    public Camp getCamp(String id) {
        return campClient.getCamp(id);
    }


    @Override
    public Camp addHero(String heroName, String campID){
        return campClient.addHero(heroName, campID).getContent();
    }

    @Override
    public Camp removeHeroFromParty(String heroID, String id) {
        return campClient.removeHeroFromParty(heroID, id).getContent();
    }

    @Override
    public Camp addHeroToParty(String heroID, String campID) {
        return campClient.addHeroToParty(heroID, campID).getContent();
    }

    @Override
    public Iterable<Item> getShopItems() {
        return shopClient.shop();
    }

    @Override
    public Item getShopItem(String itemID) {
        return shopClient.getShopItem(itemID);
    }

    @Override
    public Hero applyShopItem(String itemID, String heroID, String campID) {
        Item item = shopClient.getShopItem(itemID);
        return campClient.applyShopItem(heroID, item.getItemType().toString(), item.getPrice(), campID).getContent();
    }

    @Override
    public byte[] getHeroImage(String heroID) {
        ResponseEntity<ByteArrayResource> response = campClient.getHeroImage(heroID);
        if(response == null)
            return null;
        return Objects.requireNonNull(response.getBody()).getByteArray();
    }

    @Override
    public String changeName(String heroID, String name) {
        return campClient.changeName(heroID, name).getContent().getName();
    }

    @Override
    public History[] getHistory(String campID) {
        return historyClient.getHistory(campID);
    }

}
