package org.stajkovic.ufc.cv.service;

import org.springframework.data.domain.Page;
import org.stajkovic.ufc.cv.fighter.dto.FighterRequest;
import org.stajkovic.ufc.cv.fighter.dto.FighterResponse;


public interface FighterService {
    Page<FighterResponse> findAllFighters(int size, Integer page);
    FighterResponse findFighterById(int id);
    FighterResponse addFighter(FighterRequest fighter);

}
