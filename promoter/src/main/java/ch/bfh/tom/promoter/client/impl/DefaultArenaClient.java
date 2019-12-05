package ch.bfh.tom.promoter.client.impl;

import ch.bfh.tom.promoter.client.ArenaClient;
import ch.bfh.tom.promoter.model.Party;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DefaultArenaClient implements ArenaClient {

    @Override
    public String battle(List<Party> challangers) {
        ResponseEntity<String> response =  new RestTemplate().exchange(
                "http://localhost:3333/battle",
                HttpMethod.POST,
                new HttpEntity<>(challangers),
                String.class);
        return response.getBody();
    }
}
