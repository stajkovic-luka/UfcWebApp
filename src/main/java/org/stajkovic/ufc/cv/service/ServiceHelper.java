package org.stajkovic.ufc.cv.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.stajkovic.ufc.cv.fighter.dto.FighterResponse;
import org.stajkovic.ufc.cv.fighter.model.Fighter;


@Service
public class ServiceHelper {

    // Fighter -> FighterResponse
    public FighterResponse createDto(Fighter f) {
        return FighterResponse
                .builder()
                .fighterId(f.getId())
                .countryName(f.getCountry().getName())
                .name(f.getName())
                .nickname(f.getNickname())
                .dateOfBirth(f.getDateOfBirth())
                .wins(f.getWins())
                .draws(f.getDraws())
                .height(f.getHeight())
                .weight(f.getWeight())
                .losses(f.getLosses())
                .reach(f.getReach())
                .avgTakedownsLanded(f.getAvgTakedownsLanded())
                .avgSubmissionsAttempted(f.getAvgSubmissionsAttempted())
                .significantStrikesAbsorbed(f.getSignificantStrikesAbsorbed())
                .significantStrikesDeffence(f.getSignificantStrikesDeffence())
                .significantStrikesLanded(f.getSignificantStrikesLanded())
                .significantStrikesAccuracy(f.getSignificantStrikesAccuracy())
                .takedownAccuracy(f.getTakedownAccuracy())
                .takedownDefense(f.getTakedownDefense())
                .stance(f.getStance())

                .build();
    }

    // Page<Fighter> -> Page<FighterResponse>
    public Page<FighterResponse> createDto(Page<Fighter> fighter) {
        return fighter.map(f -> createDto(f));
    }


}
