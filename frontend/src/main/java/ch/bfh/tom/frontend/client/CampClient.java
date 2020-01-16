package ch.bfh.tom.frontend.client;

import ch.bfh.tom.frontend.client.impl.CampClientFallback;
import ch.bfh.tom.frontend.model.Camp;
import ch.bfh.tom.frontend.model.Hero;
import ch.bfh.tom.frontend.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.ContentHandler;

@FeignClient(value = "camp-service", fallback = CampClientFallback.class)
public interface CampClient {
    @RequestMapping(method = RequestMethod.GET, value = "/parties/createParty?name={name}")
    EntityModel<Party> createParty(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.GET, value = "/camps/createCamp?name={name}")
    EntityModel<Camp> createCamp(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.GET, value = "/parties")
    Party[] listParties();

    @RequestMapping(method = RequestMethod.GET, value = "/camps")
    Camp[] listCamps();

    @RequestMapping(method = RequestMethod.GET, value = "/camps/{id}")
    Camp getCamp(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.GET, value = "/camps/addHero?name={name}&campID={campID}")
    EntityModel<Camp> addHero(@PathVariable("name") String heroName, @PathVariable("campID") String campID);

    @RequestMapping(method = RequestMethod.GET, value = "/camps/addHeroToParty?heroID={heroID}&campID={campID}")
    EntityModel<Camp> addHeroToParty(@PathVariable("heroID") String heroID,@PathVariable("campID")  String campID);

    @RequestMapping(method = RequestMethod.GET, value = "/camps/removeHeroFromParty?heroID={heroID}&campID={campID}")
    EntityModel<Camp> removeHeroFromParty(@PathVariable("heroID") String heroID,@PathVariable("campID")  String campID);

    @RequestMapping(method = RequestMethod.GET, value = "/heroes/{heroID}/getImage")
    ResponseEntity<ByteArrayResource> getHeroImage(@PathVariable("heroID") String heroID);

    @RequestMapping(method = RequestMethod.GET, value = "/heroes/{heroID}/changeName?name={name}")
    EntityModel<Hero> changeName(@PathVariable("heroID") String heroID, @PathVariable("name") String name);
}
