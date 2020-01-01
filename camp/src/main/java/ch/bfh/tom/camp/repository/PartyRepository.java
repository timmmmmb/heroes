package ch.bfh.tom.camp.repository;

import ch.bfh.tom.camp.model.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "party", path = "party")
public interface PartyRepository extends CrudRepository<Party, String> {
}