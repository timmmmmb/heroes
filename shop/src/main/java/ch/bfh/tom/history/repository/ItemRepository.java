package ch.bfh.tom.history.repository;

import ch.bfh.tom.history.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "shop", path = "shop")
public interface ItemRepository extends CrudRepository<Item, String> {
}
