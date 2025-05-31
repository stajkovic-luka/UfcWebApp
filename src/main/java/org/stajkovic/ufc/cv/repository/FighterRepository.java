package org.stajkovic.ufc.cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stajkovic.ufc.cv.fighter.model.Fighter;

public interface FighterRepository extends JpaRepository<Fighter, Integer> {

}
