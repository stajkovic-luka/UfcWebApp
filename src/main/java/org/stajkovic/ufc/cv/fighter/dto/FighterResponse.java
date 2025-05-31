package org.stajkovic.ufc.cv.fighter.dto;

import lombok.Builder;

// GET -> /ufc/fighters
@Builder
public record FighterResponse(
        int fighterId,
        String name,
        String countryName
){

}
