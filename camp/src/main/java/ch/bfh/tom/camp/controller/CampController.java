package ch.bfh.tom.camp.controller;

import ch.bfh.tom.camp.model.Camp;
import ch.bfh.tom.camp.model.Hero;
import ch.bfh.tom.camp.repository.CampRepository;
import ch.bfh.tom.camp.service.CampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/camps")
public class CampController {
    @Autowired
    private CampRepository campRepository;


    @Autowired
    private CampService campService;

    @Autowired
    private RepositoryEntityLinks repositoryEntityLinks;

    @GetMapping
    public @ResponseBody
    Iterable<Camp> list() {
        return campRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Camp getById(@PathVariable String id) {
        return campRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Camp camp) {
        campRepository.save(camp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        campRepository.deleteById(id);
    }

    @GetMapping(value = "/createCamp")
    public Camp createCamp(@RequestParam String name) {

        Camp camp = campService.createCamp(name);
        camp.add(linkTo(methodOn(CampController.class).createCamp(name)).withSelfRel());

        int heroCounter = 0;
        for (Hero hero : camp.getHeroes()) {
            camp.add(repositoryEntityLinks.linkToItemResource(Hero.class, hero.getId()).withRel("hero" + heroCounter));
            heroCounter++;
        }
        return camp;
    }

}
