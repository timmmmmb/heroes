package ch.bfh.tom.camp.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Camp extends RepresentationModel {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String name;
    @OneToMany
    private Set<Hero> heroes = new HashSet<>();
    @OneToOne
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
