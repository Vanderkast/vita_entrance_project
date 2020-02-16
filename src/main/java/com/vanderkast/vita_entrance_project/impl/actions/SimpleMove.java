package com.vanderkast.vita_entrance_project.impl.actions;

import com.vanderkast.vita_entrance_project.game.Action;
import com.vanderkast.vita_entrance_project.game.Stage;
import com.vanderkast.vita_entrance_project.game.Move;
import com.vanderkast.vita_entrance_project.game.tiles.FreeTile;

public abstract class SimpleMove implements Action, Move {
    private final int deltaY, deltaX;

    public SimpleMove(int deltaY, int deltaX) {
        this.deltaY = deltaY;
        this.deltaX = deltaX;
    }

    @Override
    public boolean isAvailableFor(Stage stage, int figureY, int figureX) {
        return target(stage, figureY, figureX, deltaY, deltaX) instanceof FreeTile;
    }

    @Override
    public void run(Stage stage, int figureY, int figureX) {
        if (isAvailableFor(stage, figureY, figureX)) {
            stage.getMap().put(
                    stage.getMap().get(figureY, figureX),
                    figureY + deltaY, figureX + deltaX);
            stage.getMap().put(
                    stage.getMap().get(figureY + deltaY, figureX + deltaX),
                    figureY, figureX);
        } else
            throw new OutOfBoundsException(figureY, figureX);
    }

    public static class Up extends SimpleMove {
        public Up() {
            super(1, 0);
        }
    }

    public static class Down extends SimpleMove {
        public Down() {
            super(-1, 0);
        }
    }
}

