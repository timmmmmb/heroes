package ch.bfh.tom.camp.impl;

import ch.bfh.tom.camp.model.Hero;
import ch.bfh.tom.camp.service.HeroService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HeroServiceImpl implements HeroService {

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

        return hero;
    }
}
