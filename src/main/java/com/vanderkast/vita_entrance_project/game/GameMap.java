package com.vanderkast.vita_entrance_project.game;

import com.vanderkast.vita_entrance_project.game.tiles.Tile;

import java.util.List;

public interface GameMap {
    List<List<Tile>> getAll();

    Tile get(int y, int x);

    void put(Tile tile, int y, int x);
}
