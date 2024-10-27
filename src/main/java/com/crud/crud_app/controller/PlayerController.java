package com.crud.crud_app.controller;

import com.crud.crud_app.entity.Player;
import com.crud.crud_app.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getAllPlayer() {
        return playerRepository.findAll();
    }

    @GetMapping("/{playerID}")
    public ResponseEntity<Player> getPlayerById(@PathVariable String playerID){
        return  playerRepository.findById(playerID)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
