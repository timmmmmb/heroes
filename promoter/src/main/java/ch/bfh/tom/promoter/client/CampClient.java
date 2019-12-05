package ch.bfh.tom.promoter.client;

import ch.bfh.tom.promoter.model.Party;
import org.springframework.core.io.Resource;

public interface CampClient {
    Resource<Party> createParty(String challenger);
}
