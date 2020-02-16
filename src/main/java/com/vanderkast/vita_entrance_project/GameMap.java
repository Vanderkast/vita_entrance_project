package com.vanderkast.vita_entrance_project;

import com.vanderkast.vita_entrance_project.tiles.Tile;

import java.util.List;

public interface GameMap {
    List<List<Tile>> getAll();

    Tile get(int y, int x);

    void replace(int y, int x, Tile tile);
}
