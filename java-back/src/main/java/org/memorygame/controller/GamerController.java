package org.memorygame.controller;

import org.memorygame.model.GameScore;
import org.memorygame.model.Gamer;
import org.memorygame.repository.GameScoreRepository;
import org.memorygame.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/gamers")
public class GamerController {

    @Autowired
    GamerRepository gamerRepository;

    @Autowired
    GameScoreRepository gameScoreRepository;

    @GetMapping(value = "/getall", produces = "application/json")
    public Iterable<Gamer> getAllGamers() {
        Map<String, Object> object = new HashMap<>();
        return gamerRepository.findAll();
    }

    @GetMapping(value = "/gamer", produces = "application/json")
    public Gamer getGamerByName(@RequestParam String name) {
        return gamerRepository.findByName(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Gamer create(@RequestBody Gamer gamer) {
        return gamerRepository.save(gamer);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addscore")
    public void addScore(@RequestBody GameScore gameScore) {
    }
}
