package ch.bfh.tom.shop.repository;

import ch.bfh.tom.shop.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "heroes", path = "heroes")
public interface HeroRepository extends CrudRepository<Hero, String> { }