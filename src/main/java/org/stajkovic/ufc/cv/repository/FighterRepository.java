package org.stajkovic.ufc.cv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stajkovic.ufc.cv.fighter.model.Fighter;

import java.time.LocalDate;
import java.util.Optional;

public interface FighterRepository extends JpaRepository<Fighter, Integer> {
    Optional<Fighter> findFighterById(int id);

    Optional<Fighter> findFighterByNameAndDateOfBirth(String name, LocalDate dob);

}
