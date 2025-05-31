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
public class FighterServiceImpl implements FighterService{
    private final FighterRepository fighterRepository;

    @Override
    public Page<FighterResponse> findAllFighters(int size, Integer page) {
        // podaci o strani i velicini strane
        Pageable pageable = PageRequest.of(page,size);


        return fighterRepository.findAll(pageable)
                .map(fighter -> FighterResponse.builder() // Page<Fighter> u FighterDTO
                        .fighterId(fighter.getId())
                        .name(fighter.getName())
                        .countryName(fighter.getCountry().getNiceName())
                        .build()
                );


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
