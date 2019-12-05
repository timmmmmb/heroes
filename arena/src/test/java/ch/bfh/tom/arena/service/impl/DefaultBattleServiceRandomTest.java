package ch.bfh.tom.arena.service.impl;

import ch.bfh.tom.arena.model.Hero;
import ch.bfh.tom.arena.model.Party;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultBattleServiceRandomTest {

    @Test
    void battle() {

        List<Hero> heroes = new ArrayList<>();
        heroes.add(createHero("Superman"));
        heroes.add(createHero("Batman"));
        heroes.add(createHero("Wonder Woman"));
        heroes.add(createHero("Spiderman"));
        heroes.add(createHero("Aquaman"));
        heroes.add(createHero("Green Lantern"));
        heroes.add(createHero("Flash"));
        heroes.add(createHero("Batwoman"));

        List<Hero> villains = new ArrayList<>();
        villains.add(createHero("Deadshot"));
        villains.add(createHero("Harley Quinn"));
        villains.add(createHero("Katana"));
        villains.add(createHero("Joker"));
        villains.add(createHero("Killer Croc"));
        villains.add(createHero("El Diabolo"));
        villains.add(createHero("Rick Flag"));
        villains.add(createHero("Captain Boomerang"));

        Party justiceLeague = createParty("Justice League", heroes);
        Party suicideSquad = createParty("Suicide Squad", villains);

        DefaultBattleService battleService = new DefaultBattleService();
        String winner = battleService.battle(suicideSquad, justiceLeague);
        System.out.println(winner);
        assertTrue(true);
    }

    private Hero createHero(String name) {
        Hero hero = new Hero();
        hero.setName(name);
        int atk = new Random().nextInt(100);
        hero.setAtk(atk);
        int def = new Random().nextInt(100);
        hero.setDef(def);
        hero.setHp(100);
        return hero;
    }

    Party createParty(String name, List<Hero> heroList) {
        Party party = new Party();
        party.setName(name);
        Collections.shuffle(heroList);
        List<Hero> randomHeroes = new ArrayList<>(heroList.subList(0,4));
        party.setMembers(randomHeroes);
        return party;
    }
}