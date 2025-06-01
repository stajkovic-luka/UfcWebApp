package org.stajkovic.ufc.cv.fighter.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import org.stajkovic.ufc.cv.fighter.model.Stance;

import java.math.BigDecimal;
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
        BigDecimal height,
        BigDecimal weight,
        BigDecimal reach,
        Stance stance,

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dateOfBirth,

        BigDecimal significantStrikesLanded,
        BigDecimal significantStrikesAbsorbed,
        BigDecimal significantStrikesAccuracy,
        BigDecimal significantStrikesDeffence,
        BigDecimal avgTakedownsLanded,
        BigDecimal avgSubmissionsAttempted,
        BigDecimal takedownAccuracy,
        BigDecimal takedownDefense
) {

}
