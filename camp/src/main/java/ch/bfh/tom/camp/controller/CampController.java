package ch.bfh.tom.camp.controller;

import ch.bfh.tom.camp.model.Camp;
import ch.bfh.tom.camp.model.Hero;
import ch.bfh.tom.camp.repository.CampRepository;
import ch.bfh.tom.camp.service.CampService;
import ch.bfh.tom.camp.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
    private HeroService heroService;

    @Autowired
    private RepositoryEntityLinks repositoryEntityLinks;

    @GetMapping
    public @ResponseBody
    Camp[] list() {
        ArrayList<Camp> camps = (ArrayList<Camp>) campRepository.findAll();
        return camps.toArray(new Camp[0]);
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

    @GetMapping(value = "/addHero")
    public Camp addHero(@RequestParam String name, @RequestParam String campID) {
        Camp camp = campRepository.findById(campID).get();

        Hero hero = heroService.createHero(name);
        camp.addHeroe(hero);
        camp.add(repositoryEntityLinks.linkToItemResource(Hero.class, hero.getId()).withRel("hero" + hero.getId()));
        camp = campRepository.save(camp);
        return camp;
    }


}
