package org.stajkovic.ufc.cv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stajkovic.ufc.cv.fighter.dto.FighterResponse;
import org.stajkovic.ufc.cv.service.FighterServiceImpl;

@RestController
@RequestMapping("/ufc")
@RequiredArgsConstructor
public class FighterController {

    private final FighterServiceImpl fighterServiceImpl;


    @GetMapping("/fighters")
    public Page<FighterResponse> getFighters(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                             @RequestParam(defaultValue = "25") int size
    ) {
        return fighterServiceImpl.findAllFighters(size,page);

    }


}
