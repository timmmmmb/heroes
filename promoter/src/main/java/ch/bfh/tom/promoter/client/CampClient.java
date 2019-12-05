package ch.bfh.tom.promoter.client;

import ch.bfh.tom.promoter.model.Party;
import org.springframework.hateoas.EntityModel;

public interface CampClient {
    EntityModel<Party> createParty(String challenger);
}
