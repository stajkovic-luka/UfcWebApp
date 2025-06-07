package org.stajkovic.ufc.cv.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.stajkovic.ufc.cv.fighter.dto.FighterRequest;
import org.stajkovic.ufc.cv.fighter.dto.FighterResponse;
import org.stajkovic.ufc.cv.fighter.dto.FighterScoreRequest;
import org.stajkovic.ufc.cv.fighter.model.Stance;

import java.time.LocalDate;


public interface FighterService {
    Page<FighterResponse> findAllFighters(int size, Integer page);
    FighterResponse findFighterById(int id);
    FighterResponse addFighter(FighterRequest fighter);
    void updateFighterScore(String name, LocalDate dob, FighterScoreRequest scoreDTO);
    void deleteFighterById(int id);
    Page<FighterResponse> findFightersByStance(int pageNumber, int pageSize, String stanceStr);
    Page<FighterResponse> findFightersByWinsAge(Pageable pageable, int minAge, int wins);
}
