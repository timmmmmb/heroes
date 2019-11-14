package ch.bfh.tom.camp.repository;

import ch.bfh.tom.camp.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends CrudRepository<Hero, String> {
    long countByAtkGreaterThan(int atk);
}