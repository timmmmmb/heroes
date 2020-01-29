package ch.bfh.tom.history.repository;

import ch.bfh.tom.history.model.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "history", path = "history")
public interface HistoryRepository extends CrudRepository<History, String> {
}
