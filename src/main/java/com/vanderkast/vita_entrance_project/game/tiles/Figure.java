package com.vanderkast.vita_entrance_project.game.tiles;

import com.vanderkast.vita_entrance_project.game.Action;

import java.util.List;

public interface Figure extends Tile {
    List<Action> getActions();
}
