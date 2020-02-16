package com.vanderkast.vita_entrance_project.tiles;

import com.vanderkast.vita_entrance_project.Action;

import java.util.List;

public interface Figure extends Tile {
    List<Action> getActions();
}
