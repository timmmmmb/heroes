package ch.bfh.tom.camp.service.impl;

import ch.bfh.tom.camp.model.Hero;
import ch.bfh.tom.camp.repository.HeroRepository;
import ch.bfh.tom.camp.service.HeroService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DefaultHeroService implements HeroService {

    private HeroRepository heroRepository;

    public DefaultHeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Hero createHero(String name) {
        Hero hero = new Hero();

        Random random = new Random();

        hero.setName(name);
        hero.setAtk(random.nextInt(100) + 1);
        hero.setDef(random.nextInt(100) + 1);
        hero.setHp(100);

        System.out.println("Created new hero ...");
        System.out.println("Name: " + hero.getName());
        System.out.println("ATK:  " + hero.getAtk());
        System.out.println("DEF:  " + hero.getDef());
        System.out.println("HP:   " + hero.getHp());
        System.out.println();

        hero = this.heroRepository.save(hero);

        System.out.println("Heroes with >50 ATK: " + heroRepository.findByAtkGreaterThan(50));
        System.out.println();

        return hero;
    }
}
