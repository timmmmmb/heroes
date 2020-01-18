package ch.bfh.tom.camp.repository;

import ch.bfh.tom.camp.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HeroRepository extends CrudRepository<Hero, String> {
    long countByAtkGreaterThan(double atk);
}