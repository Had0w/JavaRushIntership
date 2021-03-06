package com.game.controller;

import com.game.entity.Player;
import com.game.service.PlayerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(name = "/rest/players")
public class PlayerController {
    private PlayerServiceImp playerServiceImp;

    @Autowired
    public void setPlayerServiceImp(PlayerServiceImp playerServiceImp) {
        this.playerServiceImp = playerServiceImp;
    }

    @GetMapping
    public String getAllPlayers(Model model){
        List<Player> players = playerServiceImp.getAllPlayers();
        model.addAttribute("players", players);
        return "index";
    }

    @PostMapping
    public String addPlayer(@ModelAttribute("player") Player player) {
        playerServiceImp.addPlayer(player);
        return "redirect:/index";
    }

    @DeleteMapping("{id}")
    public String deletePlayer(@RequestParam("id") long id) {
        return "redirect:/index";
    }

}
