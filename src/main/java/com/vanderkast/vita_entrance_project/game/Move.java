package com.vanderkast.vita_entrance_project.game;

import com.vanderkast.vita_entrance_project.game.tiles.Tile;

public interface Move {
    default Tile target(Stage stage, int figureY, int figureX, int deltaY, int deltaX) {
        return stage.getMap().get(figureY + deltaY, figureX + deltaX);
    }
}
