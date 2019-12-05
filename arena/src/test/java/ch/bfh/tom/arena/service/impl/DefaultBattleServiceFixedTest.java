package ch.bfh.tom.arena.service.impl;

import ch.bfh.tom.arena.model.Hero;
import ch.bfh.tom.arena.model.Party;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultBattleServiceFixedTest {

    @Test
    void battle() {

        Party chalengeeParty = new Party();
        chalengeeParty.setName("ChalengeeParty");

        List<Hero> chalengeeMembers = new ArrayList<>();

        Hero chalengeeHero0 = new Hero();
        chalengeeHero0.setName("ChalengeeHero0");
        chalengeeHero0.setAtk(50);
        chalengeeHero0.setDef(50);
        chalengeeHero0.setHp(100.0);
        chalengeeMembers.add(chalengeeHero0);

        Hero chalengeeHero1 = new Hero();
        chalengeeHero1.setName("ChalengeeHero1");
        chalengeeHero1.setAtk(0);
        chalengeeHero1.setDef(100);
        chalengeeHero1.setHp(100.0);
        chalengeeMembers.add(chalengeeHero1);

        Hero chalengeeHero2 = new Hero();
        chalengeeHero2.setName("ChalengeeHero2");
        chalengeeHero2.setAtk(0);
        chalengeeHero2.setDef(0);
        chalengeeHero2.setHp(100.0);
        chalengeeMembers.add(chalengeeHero2);

        Hero chalengeeHero3 = new Hero();
        chalengeeHero3.setName("ChalengeeHero3");
        chalengeeHero3.setAtk(78);
        chalengeeHero3.setDef(34);
        chalengeeHero3.setHp(100.0);
        chalengeeMembers.add(chalengeeHero3);

        chalengeeParty.setMembers(chalengeeMembers);

        Party chalengerParty = new Party();
        chalengerParty.setName("ChalengerParty");

        List<Hero> chalengerMembers = new ArrayList<>();

        Hero chalengerHero0 = new Hero();
        chalengerHero0.setName("ChalengerHero0");
        chalengerHero0.setAtk(50);
        chalengerHero0.setDef(50);
        chalengerHero0.setHp(100.0);
        chalengerMembers.add(chalengerHero0);

        Hero chalengerHero1 = new Hero();
        chalengerHero1.setName("ChalengerHero1");
        chalengerHero1.setAtk(100);
        chalengerHero1.setDef(0);
        chalengerHero1.setHp(100.0);
        chalengerMembers.add(chalengerHero1);

        Hero chalengerHero2 = new Hero();
        chalengerHero2.setName("ChalengerHero2");
        chalengerHero2.setAtk(0);
        chalengerHero2.setDef(0);
        chalengerHero2.setHp(100.0);
        chalengerMembers.add(chalengerHero2);

        Hero chalengerHero3 = new Hero();
        chalengerHero3.setName("ChalengerHero3");
        chalengerHero3.setAtk(82);
        chalengerHero3.setDef(45);
        chalengerHero3.setHp(100.0);
        chalengerMembers.add(chalengerHero3);

        chalengerParty.setMembers(chalengerMembers);


        DefaultBattleService battleService = new DefaultBattleService();
        String winner = battleService.battle(chalengeeParty, chalengerParty);

        assertEquals(winner, chalengerParty.getName());
    }
}