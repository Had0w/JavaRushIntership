package com.game.service;

import com.game.entity.Player;
;

import java.util.List;
public interface PlayerService {

    List<Player> getAllPlayers();

    void addPlayer(Player player);
}
