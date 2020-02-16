package com.vanderkast.vita_entrance_project.game;

import java.util.List;

public interface Stage {
    GameMap getMap();

    List<Player> getPlayers();

    int currentPlayer();

    abstract class Win implements Stage {

    }
}
