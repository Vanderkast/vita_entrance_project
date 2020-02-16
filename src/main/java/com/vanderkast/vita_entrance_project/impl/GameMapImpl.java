package com.vanderkast.vita_entrance_project.impl;

import com.vanderkast.vita_entrance_project.impl.tiles.FirstPlayerFigure;
import com.vanderkast.vita_entrance_project.game.GameMap;
import com.vanderkast.vita_entrance_project.impl.tiles.SecondPlayerFigure;
import com.vanderkast.vita_entrance_project.game.tiles.*;

import java.util.ArrayList;
import java.util.List;

public class GameMapImpl implements GameMap {
    private final List<List<Tile>> map = new ArrayList<>(5);

    public GameMapImpl() {
        map.add(of(new EmptyTileImpl(), new FreeTileImpl(), new EmptyTileImpl()));
        map.add(of(new FreeTileImpl(), new FreeTileImpl(), new FreeTileImpl()));
        map.add(of(new FreeTileImpl(), new SecondPlayerFigure(), new FreeTileImpl()));
        map.add(of(new FirstPlayerFigure(), new FreeTileImpl(), new FirstPlayerFigure()));
        map.add(of(new FreeTileImpl(), new FirstPlayerFigure(), new FreeTileImpl()));
    }

    private ArrayList<Tile> of(Tile a, Tile b, Tile c) {
        ArrayList<Tile> tiles = new ArrayList<>(3);
        tiles.add(a);
        tiles.add(b);
        tiles.add(c);
        return tiles;
    }

    @Override
    public List<List<Tile>> getAll() {
        return map;
    }

    @Override
    public Tile get(int y, int x) {
        if (y < map.size() && x < map.get(y).size())
            return map.get(y).get(x);
        return null;
    }

    @Override
    public void put(Tile tile, int y, int x) {
        if (y < map.size() && x < map.get(y).size())
            map.get(y).add(x, tile);
    }

    public static class FreeTileImpl implements FreeTile {
    }

    public static class EmptyTileImpl implements EmptyTile {
    }
}
