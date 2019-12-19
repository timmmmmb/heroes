package ch.bfh.tom.promoter.client.impl;

import ch.bfh.tom.promoter.client.CampClient;
import ch.bfh.tom.promoter.model.Party;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

@Component
public class CampClientFallback implements CampClient {

    @Override
    public EntityModel<Party> createParty(String name) {
        System.out.println("Using Fallback");
        return new EntityModel<>(new Party());
    }
}
