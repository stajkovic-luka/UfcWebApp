package org.stajkovic.ufc.cv.service;

import org.stajkovic.ufc.cv.model.Country;
import org.stajkovic.ufc.cv.model.Fighter;

import java.util.List;
import java.util.Optional;

public interface FighterService {
    List<Fighter> findAllFighters();
    Optional<Fighter> findFighterById();
    List<Fighter> findFighterByName(String name);
    void filterByCountry(String name);
    void addFighter(int id);
    void updateFighterStats();
    void deleteFighterById(int id);


}
