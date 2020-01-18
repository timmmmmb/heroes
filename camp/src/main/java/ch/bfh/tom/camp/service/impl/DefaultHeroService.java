package ch.bfh.tom.camp.service.impl;

import ch.bfh.tom.camp.CampApplicationRunner;
import ch.bfh.tom.camp.model.Hero;
import ch.bfh.tom.camp.model.ItemType;
import ch.bfh.tom.camp.repository.HeroRepository;
import ch.bfh.tom.camp.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class DefaultHeroService implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Hero createHero(String name) {
        Hero hero = new Hero();

        Random random = new Random();

        hero.setName(name);
        hero.setAtk(1 + (100 - 1) * random.nextDouble());
        hero.setDef(1 + (100 - 1) * random.nextDouble());
        hero.setHp(100);
        hero.setGold(50);
        ArrayList<String> images = CampApplicationRunner.getImages();
        hero.setImagePath(images.get(random.nextInt(images.size())));

        System.out.println("Created new hero ...");
        System.out.println("Name: " + hero.getName());
        System.out.println("ATK:  " + hero.getAtk());
        System.out.println("DEF:  " + hero.getDef());
        System.out.println("HP:   " + hero.getHp());
        System.out.println("Gold: " + hero.getGold());
        System.out.println();

        String id = this.heroRepository.save(hero).getId();

        System.out.println("Heroes with >50 ATK: " + heroRepository.countByAtkGreaterThan(50));
        System.out.println();

        return heroRepository.findById(id).get();
    }

    @Override
    public Hero applyShopItem(String id, String itemType, double itemPrice) {

        Hero hero = heroRepository.findById(id).get();

        double heroGold = hero.getGold();
        if (heroGold >= itemPrice) {
            hero.setGold(heroGold - itemPrice);

            ItemType type = ItemType.valueOf(itemType);
            switch(type) {
                case ATTACK:
                    hero.setAtk(hero.getAtk() + itemPrice);
                    break;
                case DEFENSE:
                    hero.setDef(hero.getDef() + itemPrice);
                    break;
                case HEALTH:
                    hero.setHp(hero.getHp() + itemPrice);
                    break;
            }
        }

        hero = heroRepository.save(hero);
        return hero;
    }
}
