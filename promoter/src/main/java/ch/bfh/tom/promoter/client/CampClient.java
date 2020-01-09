package ch.bfh.tom.promoter.client;

import ch.bfh.tom.promoter.client.impl.CampClientFallback;
import ch.bfh.tom.promoter.model.Camp;
import ch.bfh.tom.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "camp-service", fallback = CampClientFallback.class)
public interface CampClient {
    @RequestMapping(method = RequestMethod.GET, value = "/parties/createParty?name={name}")
    EntityModel<Party> createParty(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.GET, value = "/camps/{campID}")
    Camp getCamp(@PathVariable("campID") String campID);

    @RequestMapping(method = RequestMethod.GET, value = "/camps/findOpponent?campID={campID}")
    Camp getOpponent(@PathVariable("campID") String campID);
}
