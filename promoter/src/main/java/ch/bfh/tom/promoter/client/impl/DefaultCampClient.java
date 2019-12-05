package ch.bfh.tom.promoter.client.impl;

import ch.bfh.tom.promoter.client.CampClient;
import ch.bfh.tom.promoter.model.Party;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DefaultCampClient implements CampClient {

    @Override
    public Resource<Party> createParty(String name) {
        ResponseEntity<Resource<Party>> response = new RestTemplate().exchange(
                "http://localhost:2222/createParty?name={name}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Resource<Party>>() {}
                , name);
        return response.getBody();
    }
}
