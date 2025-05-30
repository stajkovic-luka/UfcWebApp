package org.stajkovic.ufc.cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stajkovic.ufc.cv.model.Fighter;

public interface FighterRepository extends JpaRepository<Fighter, Integer> {


}
