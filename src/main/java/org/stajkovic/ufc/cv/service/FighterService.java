package org.stajkovic.ufc.cv.service;

import org.springframework.data.domain.Page;
import org.stajkovic.ufc.cv.fighter.dto.FighterResponse;
import org.stajkovic.ufc.cv.fighter.model.Fighter;

import java.util.List;
import java.util.Optional;

public interface FighterService {
    Page<FighterResponse> findAllFighters(int size, Integer page);
    Optional<FighterResponse> findFighterById(int id);
    List<Fighter> findFighterByName(String name);
    void filterByCountry(String name);
    void addFighter(int id);
    void updateFighterStats();
    void deleteFighterById(int id);


}
