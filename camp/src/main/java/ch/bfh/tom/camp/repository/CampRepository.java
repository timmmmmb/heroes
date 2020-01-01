package ch.bfh.tom.camp.repository;

import ch.bfh.tom.camp.model.Camp;
import ch.bfh.tom.camp.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "camp", path = "camp")
public interface CampRepository extends CrudRepository<Camp, String> {
}