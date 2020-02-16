package com.vanderkast.vita_entrance_project.actions;

import com.vanderkast.vita_entrance_project.Stage;
import com.vanderkast.vita_entrance_project.tiles.Tile;

public interface Move {
    default Tile target(Stage stage, int figureY, int figureX, int deltaY, int deltaX) {
        return stage.getMap().get(figureY + deltaY, figureX + deltaX);
    }
}
