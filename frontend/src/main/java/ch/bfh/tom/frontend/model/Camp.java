package ch.bfh.tom.frontend.model;

import org.springframework.hateoas.RepresentationModel;

import java.util.HashSet;
import java.util.Set;

public class Camp extends RepresentationModel {
    private String id;
    private String name;
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

    public void setHeroes(Set<Hero> heroes) {
        this.heroes = heroes;
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
}
