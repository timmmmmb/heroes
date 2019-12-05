package ch.bfh.tom.promoter.client;

import ch.bfh.tom.promoter.model.Party;
import org.springframework.http.ResponseEntity;

public interface CampClient {
    ResponseEntity<Party> createParty(String challenger);
}
