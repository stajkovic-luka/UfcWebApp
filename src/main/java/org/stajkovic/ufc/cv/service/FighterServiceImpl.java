package org.stajkovic.ufc.cv.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.stajkovic.ufc.cv.fighter.dto.FighterResponse;
import org.stajkovic.ufc.cv.fighter.model.Fighter;
import org.stajkovic.ufc.cv.repository.FighterRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log
public class FighterServiceImpl implements FighterService {
    private final FighterRepository fighterRepository;
    private final ServiceHelper serviceHelper;

    @Override
    public Page<FighterResponse> findAllFighters(int size, Integer page) {
        // podaci o strani i velicini strane
        Pageable pageable = PageRequest.of(page, size);
        Page<Fighter> allFighters = fighterRepository.findAll(pageable);

        return serviceHelper.createDto(allFighters);
    }

    @Override
    public Optional<FighterResponse> findFighterById(int id) {
        Optional<Fighter> fighter = fighterRepository.findFighterById(id);
        if (fighter.isEmpty()) {
            // vrati da borac nije nadjen poruku i http status code.
            log.warning("Borac sa trazenim id nije nadjen u bazi.");
        }


        return serviceHelper.createDto(fighter);
    }

    @Override
    public List<Fighter> findFighterByName(String name) {
        return List.of();
    }

    @Override
    public void filterByCountry(String name) {

    }

    @Override
    public void addFighter(int id) {

    }

    @Override
    public void updateFighterStats() {

    }

    @Override
    public void deleteFighterById(int id) {

    }
}
