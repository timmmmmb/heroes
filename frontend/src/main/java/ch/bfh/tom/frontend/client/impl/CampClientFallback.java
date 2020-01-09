package ch.bfh.tom.frontend.client.impl;


import ch.bfh.tom.frontend.client.CampClient;
import ch.bfh.tom.frontend.model.Camp;
import ch.bfh.tom.frontend.model.Party;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CampClientFallback implements CampClient {

    @Override
    public EntityModel<Party> createParty(String name) {
        System.out.println("Using Fallback");
        Party party = new Party();
        party.setName("Fallback Party");
        return new EntityModel<>(party);
    }

    @Override
    public EntityModel<Camp> createCamp(String name) {
        System.out.println("Using Fallback");
        return new EntityModel<>(new Camp());
    }

    @Override
    public Party[] listParties() {
        System.out.println("Using Fallback");
        return new Party[0];
    }

    @Override
    public Camp[] listCamps() {
        System.out.println("Using Fallback");
        return new Camp[0];
    }

    @Override
    public Camp getCamp(String id) {
        System.out.println("Using Fallback");
        return null;
    }

    @Override
    public EntityModel<Camp> addHero(String heroName, String campID) {
        System.out.println("Using Fallback");
        return null;
    }

    @Override
    public EntityModel<Camp> addHeroToParty(String heroID, String campID) {
        System.out.println("Using Fallback");
        return new EntityModel<>(new Camp());
    }

    @Override
    public EntityModel<Camp> removeHeroFromParty(String heroID, String campID) {
        System.out.println("Using Fallback");
        return new EntityModel<>(new Camp());
    }

    @Override
    public ResponseEntity<ByteArrayResource> getHeroImage(String heroID) {
        System.out.println("Using Fallback");
        return null;
    }
}
