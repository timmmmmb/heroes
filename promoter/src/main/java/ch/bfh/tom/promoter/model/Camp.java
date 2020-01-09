package ch.bfh.tom.promoter.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Objects;
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

    public void addHeroe(Hero hero) {
        heroes.add(hero);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Camp camp = (Camp) o;
        return Objects.equals(getId(), camp.getId()) &&
                Objects.equals(getName(), camp.getName()) &&
                Objects.equals(getHeroes(), camp.getHeroes()) &&
                Objects.equals(getParty(), camp.getParty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getName(), getHeroes(), getParty());
    }
}
