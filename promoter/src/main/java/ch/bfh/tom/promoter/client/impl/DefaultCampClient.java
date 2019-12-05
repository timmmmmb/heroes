package ch.bfh.tom.promoter.client.impl;

import ch.bfh.tom.promoter.client.CampClient;
import ch.bfh.tom.promoter.model.Party;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class DefaultCampClient implements CampClient {

    @Override
    public ResponseEntity<Party> createParty(String name) {
        ResponseEntity<Party> response = new RestTemplate().exchange(
                "http://localhost:2222/createParty?name={name}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Party>() {}
                , name);
        return response;
    }
}
