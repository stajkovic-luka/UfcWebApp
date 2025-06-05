package org.stajkovic.ufc.cv.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
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


    @GetMapping("/fighters")
    public Page<FighterResponse> getFighters(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                             @RequestParam(defaultValue = "25") int size
    ) {
        return fighterServiceImpl.findAllFighters(size, page);

    }

    @GetMapping("/fighters/{id}")
    public FighterResponse getFighterById(@PathVariable(name = "id") int id) {
        return fighterServiceImpl.findFighterById(id);
    }

    @PostMapping("/fighters")
    public ResponseEntity<FighterResponse> addFighter(@RequestBody FighterRequest fighterRequest) {

        FighterResponse fighterResponse = fighterServiceImpl.addFighter(fighterRequest);
        return ResponseEntity
                .status(201)
                .body(fighterResponse);
    }

    @PatchMapping("/fighters")
    public ResponseEntity<String> modifyScoreFighter(@RequestParam String name,
                                                              @RequestParam LocalDate dob,
                                                              @RequestBody FighterScoreRequest fighterScoreRequest
                                                              ) {
        fighterServiceImpl.updateFighterScore(name,dob,fighterScoreRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Podaci o pobedama azurirani.");
    }

    @DeleteMapping("/fighters/{id}")
    public ResponseEntity<String> deleteFighter(@PathVariable(name = "id") int id){

        fighterServiceImpl.deleteFighterById(id);


        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Borac uspesno obrisan.");
    }

}
