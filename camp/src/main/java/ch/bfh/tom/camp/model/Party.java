package ch.bfh.tom.camp.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Party {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String name;

    @OneToMany
    private List<Hero> members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hero> getMembers() {
        return members;
    }

    public void setMembers(List<Hero> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
