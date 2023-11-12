package org.memorygame.repository;

import org.memorygame.model.GameScore;
import org.springframework.data.repository.CrudRepository;

public interface GameScoreRepository extends CrudRepository<GameScore, Long> {

}
