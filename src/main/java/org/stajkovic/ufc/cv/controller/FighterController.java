package org.stajkovic.ufc.cv.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stajkovic.ufc.cv.fighter.dto.FighterRequest;
import org.stajkovic.ufc.cv.fighter.dto.FighterResponse;
import org.stajkovic.ufc.cv.fighter.dto.FighterScoreRequest;
import org.stajkovic.ufc.cv.service.FighterServiceImpl;

import java.time.LocalDate;

@Log
@RestController
@RequestMapping("/ufc")
@RequiredArgsConstructor
public class FighterController {

    private final FighterServiceImpl fighterServiceImpl;

    // Vraca sve borce
    @GetMapping("/fighters")
    public Page<FighterResponse> getFighters(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                             @RequestParam(defaultValue = "25") int size
    ) {
        return fighterServiceImpl.findAllFighters(size, page);

    }

    // Vraca borca na osnovu njegovog id-a
    @GetMapping("/fighters/{id}")
    public FighterResponse getFighterById(@PathVariable(name = "id") int id) {
        return fighterServiceImpl.findFighterById(id);
    }

    // Dodavanje boraca
    @PostMapping("/fighters")
    public ResponseEntity<FighterResponse> addFighter(@RequestBody FighterRequest fighterRequest) {

        FighterResponse fighterResponse = fighterServiceImpl.addFighter(fighterRequest);
        return ResponseEntity
                .status(201)
                .body(fighterResponse);
    }

    // Vraca sve borce
    @PatchMapping("/fighters")
    public ResponseEntity<String> modifyScoreFighter(@RequestParam String name,
                                                     @RequestParam LocalDate dob,
                                                     @RequestBody FighterScoreRequest fighterScoreRequest
    ) {
        fighterServiceImpl.updateFighterScore(name, dob, fighterScoreRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Podaci o pobedama azurirani.");
    }

    // Brise borca na osnovu id-a
    @DeleteMapping("/fighters/{id}")
    public ResponseEntity<String> deleteFighter(@PathVariable(name = "id") int id) {

        fighterServiceImpl.deleteFighterById(id);


        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Borac uspesno obrisan.");
    }

    // Vraca borce na osnovu stila borbe
    @GetMapping("/fighters/stats")
    public Page<FighterResponse> fetchFighersByStance(@RequestParam(name = "p", defaultValue = "0") int pageNum,
                                                      @RequestParam(defaultValue = "25") int pageSize,
                                                      @RequestParam(name = "stance") String stance
    ) {
        return fighterServiceImpl.findFightersByStance(pageNum, pageSize, stance);
    }

    // Prikazuje sve borce sa brojem pobeda vecim od datih, stariji od godina datih. Sortirano rastuce prema "wins"
    @GetMapping("/fighters/stats2")
    public Page<FighterResponse> fetchFightersByMinWinsAndMinAge(@RequestParam(name = "age") int minAge,
                                                                 @RequestParam(name = "wins") int minWins,
                                                                 @RequestParam(name = "p", defaultValue = "0") int pageNum,
                                                                 @RequestParam(name = "size", defaultValue = "40") int pageSize
    ) {
        Pageable pageable;

        pageable = PageRequest.of(pageNum, pageSize, Sort.by(Sort.Direction.ASC, "wins"));


        return fighterServiceImpl.findFightersByWinsAge(pageable, minAge, minWins);
    }


}
