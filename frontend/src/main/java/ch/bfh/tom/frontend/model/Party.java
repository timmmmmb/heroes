package ch.bfh.tom.frontend.model;

import org.springframework.hateoas.RepresentationModel;

import java.util.HashSet;
import java.util.Set;

public class Party extends RepresentationModel {
    private String id;
    private String name;
    private Set<Hero> members;

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

    public String getId() {
        return id;
    }
}
