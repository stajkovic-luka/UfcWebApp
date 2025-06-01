package org.stajkovic.ufc.cv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.stajkovic.ufc.cv.fighter.dto.FighterResponse;
import org.stajkovic.ufc.cv.service.FighterServiceImpl;

import java.util.Optional;

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
    public Optional<FighterResponse> getFighterById(@PathVariable(name = "id") int id) {
        return fighterServiceImpl.findFighterById(id);
    }

}
