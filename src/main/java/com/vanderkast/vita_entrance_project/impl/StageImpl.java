package com.vanderkast.vita_entrance_project.impl;

import com.vanderkast.vita_entrance_project.game.GameMap;
import com.vanderkast.vita_entrance_project.game.Player;
import com.vanderkast.vita_entrance_project.game.Stage;

import java.util.List;

public class StageImpl implements Stage {
    private final GameMap gameMap;
    private final List<Player> players;

    private int currentPlayer;

    public StageImpl(GameMap gameMap, List<Player> players) {
        this.gameMap = gameMap;
        this.players = players;
        currentPlayer = 0;
    }

    @Override
    public GameMap getMap() {
        return gameMap;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public int currentPlayer() {
        return currentPlayer;
    }
}
