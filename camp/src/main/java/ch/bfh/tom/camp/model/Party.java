package ch.bfh.tom.camp.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Party extends RepresentationModel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String name;

    @OneToMany
    private Set<Hero> members = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Hero> getMembers() {
        return members;
    }

    public void setMembers(HashSet<Hero> members) {
        this.members = members;
    }

    public void addMember(Hero hero){
        this.members.add(hero);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return id == party.id &&
                name.equals(party.name) &&
                members.equals(party.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, members);
    }
}
