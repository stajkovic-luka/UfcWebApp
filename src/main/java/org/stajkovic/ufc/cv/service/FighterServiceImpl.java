package org.stajkovic.ufc.cv.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.stajkovic.ufc.cv.model.Fighter;
import org.stajkovic.ufc.cv.repository.FighterRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FighterServiceImpl implements FighterService{
    private final FighterRepository fighterRepository;


    @Override
    public List<Fighter> findAllFighters() {
        return List.of();
    }

    @Override
    public Optional<Fighter> findFighterById() {
        return Optional.empty();
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
