package org.memorygame.service;

import org.memorygame.model.Gamer;
import org.memorygame.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GamerService {

    @Autowired
    private GamerRepository gamerRepository;


}
