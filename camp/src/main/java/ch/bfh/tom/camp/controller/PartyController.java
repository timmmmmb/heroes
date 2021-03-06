package ch.bfh.tom.camp.controller;

import ch.bfh.tom.camp.model.Hero;
import ch.bfh.tom.camp.model.Party;
import ch.bfh.tom.camp.repository.HeroRepository;
import ch.bfh.tom.camp.repository.PartyRepository;
import ch.bfh.tom.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/parties")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @Autowired
    private RepositoryEntityLinks repositoryEntityLinks;


    @Autowired
    private PartyRepository partyRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Party> list() {
        return partyRepository.findAll();
    }

    @GetMapping(value = "/createParty")
    public Party createParty(@RequestParam String name) {

        Party party = partyService.createParty(name);
        party.add(linkTo(methodOn(PartyController.class).createParty(name)).withSelfRel());

        int heroCounter = 0;
        for (Hero hero : party.getMembers()) {
            party.add(repositoryEntityLinks.linkToItemResource(Hero.class, hero.getId()).withRel("hero" + heroCounter));
            heroCounter++;
        }
        return party;
    }
}
