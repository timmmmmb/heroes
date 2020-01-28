package ch.bfh.tom.history.repository;

import ch.bfh.tom.history.model.Battle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "battle", path = "battle")
public interface BattleRepository extends CrudRepository<Battle, String> {
}
