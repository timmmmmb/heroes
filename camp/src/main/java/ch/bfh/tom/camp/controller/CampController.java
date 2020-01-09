package ch.bfh.tom.camp.controller;

import ch.bfh.tom.camp.model.Camp;
import ch.bfh.tom.camp.model.Hero;
import ch.bfh.tom.camp.repository.CampRepository;
import ch.bfh.tom.camp.repository.HeroRepository;
import ch.bfh.tom.camp.service.CampService;
import ch.bfh.tom.camp.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/camps")
public class CampController {
    @Autowired
    private CampRepository campRepository;
    @Autowired
    private HeroRepository heroRepository;


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

    @GetMapping(value = "/addHeroToParty")
    public Camp addHeroToParty(@RequestParam String heroID, @RequestParam String campID) {
        Camp camp = campRepository.findById(campID).get();
        Hero hero = heroRepository.findById(heroID).get();
        camp.getParty().addMember(hero);
        camp = campRepository.save(camp);
        return camp;
    }

    @GetMapping(value = "/removeHeroFromParty")
    public Camp removeHeroFromParty(@RequestParam String heroID, @RequestParam String campID) {
        Camp camp = campRepository.findById(campID).get();
        Hero hero = heroRepository.findById(heroID).get();
        camp.getParty().removeMember(hero);
        camp = campRepository.save(camp);
        return camp;
    }

    @GetMapping(value = "/findOpponent")
    public Camp findOpponent(@RequestParam String campID) {
        Camp camp = campRepository.findById(campID).get();
        int strength = camp.getParty().getStrength();
        ArrayList<Camp> camps = (ArrayList<Camp>) campRepository.findAll();
        camps.remove(camp);
        camps.sort(new SortByStrength(camp));
        int position = new Random().nextInt(Math.min(camps.size(), 10));
        return camps.get(position);
    }

    static class SortByStrength implements Comparator<Camp>
    {
        private Camp camp;
        SortByStrength(Camp camp){
            this.camp = camp;
        }
        // Used for sorting in ascending order of
        // roll number
        public int compare(Camp a, Camp b)
        {
            return Math.abs(a.getParty().getStrength()-camp.getParty().getStrength())-Math.abs(b.getParty().getStrength()-camp.getParty().getStrength());
        }
    }

}
