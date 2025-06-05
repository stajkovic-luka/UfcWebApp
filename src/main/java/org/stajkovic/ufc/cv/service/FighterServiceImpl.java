package org.stajkovic.ufc.cv.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.stajkovic.ufc.cv.country.model.Country;
import org.stajkovic.ufc.cv.exception.CountryNotFoundException;
import org.stajkovic.ufc.cv.exception.FighterNotFoundException;
import org.stajkovic.ufc.cv.fighter.dto.FighterRequest;
import org.stajkovic.ufc.cv.fighter.dto.FighterResponse;
import org.stajkovic.ufc.cv.fighter.dto.FighterScoreRequest;
import org.stajkovic.ufc.cv.fighter.model.Fighter;
import org.stajkovic.ufc.cv.repository.CountryRepository;
import org.stajkovic.ufc.cv.repository.FighterRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Log
public class FighterServiceImpl implements FighterService {
    private final FighterRepository fighterRepository;
    private final ServiceHelper serviceHelper;
    private final CountryRepository countryRepository;

    @Override
    public Page<FighterResponse> findAllFighters(int size, Integer page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Fighter> allFighters = fighterRepository.findAll(pageable);

        return serviceHelper.createDto(allFighters);
    }

    @Override
    public FighterResponse findFighterById(int id) {
        Optional<Fighter> fighter = fighterRepository.findFighterById(id);
        if (fighter.isEmpty()) {
            throw new FighterNotFoundException("Borac sa id: " + id + " nije nadjen.", 404);
        }


        return serviceHelper.createDto(fighter.get());
    }



    @Override
    @Transactional
    public FighterResponse addFighter(FighterRequest fighterRequest) {
        log.info(String.valueOf(fighterRequest.countryName()));
        Country country = countryRepository.findCountryByNiceName(
                fighterRequest.countryName()).orElseThrow(() -> new CountryNotFoundException("Greska. Uneta drzava nije nadjena"));

        Fighter fighter = Fighter.builder()
                .country(country)
                .name(fighterRequest.name())
                .nickname(fighterRequest.nickname())
                .wins(fighterRequest.wins())
                .losses(fighterRequest.losses())
                .draws(fighterRequest.draws())
                .height(fighterRequest.height())
                .weight(fighterRequest.weight())
                .reach(fighterRequest.reach())
                .stance(fighterRequest.stance())
                .dateOfBirth(fighterRequest.dateOfBirth())
                .significantStrikesLanded(fighterRequest.significantStrikesLanded())
                .significantStrikesAccuracy(fighterRequest.significantStrikesAccuracy())
                .significantStrikesAbsorbed(fighterRequest.significantStrikesAbsorbed())
                .significantStrikesDeffence(fighterRequest.significantStrikesDeffence())
                .takedownAccuracy(fighterRequest.takedownAccuracy())
                .takedownDefense(fighterRequest.takedownDefense())
                .avgTakedownsLanded(fighterRequest.avgTakedownsLanded())
                .avgSubmissionsAttempted(fighterRequest.avgSubmissionsAttempted())
                .build();

                Fighter savedFighter = fighterRepository.save(fighter);
                return serviceHelper.createDto(savedFighter);

    }

    @Override
    @Transactional
    public void updateFighterScore(String name, LocalDate dob, FighterScoreRequest scoreDTO) {
        Fighter fighterToModify = fighterRepository.findFighterByNameAndDateOfBirth(name,dob)
                .orElseThrow(() -> new FighterNotFoundException("Rezultat nije azuriran. Borac nije pronadjen u bazi.",400));

        fighterToModify.setWins(scoreDTO.win());
        fighterToModify.setLosses(scoreDTO.loss());
        fighterToModify.setDraws(scoreDTO.draw());

        fighterRepository.save(fighterToModify);

    }

    @Override
    @Transactional
    public void deleteFighterById(int id) {
    int rowsChanged = fighterRepository.deleteFighterById(id);
        if (rowsChanged == 0){
            throw new FighterNotFoundException("Brisanje neuspesno. Borac nije pronadjen u bazi", HttpStatus.BAD_REQUEST.value());
        }

    }
}
