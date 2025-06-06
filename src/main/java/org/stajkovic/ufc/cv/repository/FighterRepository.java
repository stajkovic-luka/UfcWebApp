package org.stajkovic.ufc.cv.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.stajkovic.ufc.cv.fighter.model.Fighter;
import org.stajkovic.ufc.cv.fighter.model.Stance;

import java.time.LocalDate;
import java.util.Optional;

public interface FighterRepository extends JpaRepository<Fighter, Integer> {
    Optional<Fighter> findFighterById(int id);

    Optional<Fighter> findFighterByNameAndDateOfBirth(String name, LocalDate dob);

    @Query("SELECT f FROM Fighter f where f.wins >= :wins AND f.dateOfBirth <= :givenDob")
    Page<Fighter> findFightersByWinsAndAge(Pageable pageable, int wins, LocalDate givenDob);

    @Modifying
    @Query("DELETE FROM Fighter f WHERE f.id= :id")
    int deleteFighterById(@Param("id") int idFighter);

    Page<Fighter> findFightersByStance(Pageable pageable, Stance stance);

    @Query("select count(*) FROM Fighter")
    int countFighters();

}
