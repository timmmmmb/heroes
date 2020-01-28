package ch.bfh.tom.history.model;

import org.springframework.hateoas.RepresentationModel;

import java.util.HashSet;
import java.util.Set;

public class Camp extends RepresentationModel {

    private String id;
    private String name;
    private double gold;

    private Set<Hero> heroes = new HashSet<>();

    private Party party;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Hero> getHeroes() {
        return heroes;
    }

    public void addHeroes(Set<Hero> heroes){
        this.heroes.addAll(heroes);
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public String getId() {
        return id;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }
}
