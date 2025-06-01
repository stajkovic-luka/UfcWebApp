package org.stajkovic.ufc.cv.fighter.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import org.stajkovic.ufc.cv.fighter.model.Stance;

import java.time.LocalDate;

// GET -> /ufc/fighters
@Builder
public record FighterResponse(
        int fighterId,
        String name,
        String countryName,
        String nickname,
        int wins,
        int losses,
        int draws,
        double height,
        double weight,
        double reach,
        Stance stance,

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dateOfBirth,
        
        double significantStrikesLanded,
        double significantStrikesAbsorbed,
        double significantStrikesAccuracy,
        double significantStrikesDeffence,
        double avgTakedownsLanded,
        double avgSubmissionsAttempted,
        double takedownAccuracy,
        double takedownDefense
) {

}
