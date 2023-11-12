package org.memorygame.repository;

import org.memorygame.model.Gamer;
import org.springframework.data.repository.CrudRepository;

public interface GamerRepository extends CrudRepository<Gamer, Long> {

    Gamer findByName(String name);

}
