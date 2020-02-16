package com.vanderkast.vita_entrance_project.actions;

import com.vanderkast.vita_entrance_project.Action;
import com.vanderkast.vita_entrance_project.Stage;
import com.vanderkast.vita_entrance_project.tiles.FreeTile;

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
            stage.getMap().replace(
                    figureY + deltaY, figureX + deltaX,
                    stage.getMap().get(figureY, figureX));
            stage.getMap().replace(
                    figureY, figureX,
                    stage.getMap().get(figureY + deltaY, figureX + deltaX));
        } else
            throw new OutOfBoundsException(figureY, figureX);
    }

    public static class Up extends SimpleMove {
        public Up() {
            super(1, 0);
        }
    }

    public static class Left extends SimpleMove {
        public Left() {
            super(0, -1);
        }
    }

    public static class Right extends SimpleMove {
        public Right() {
            super(0, 1);
        }
    }

    public static class Down extends SimpleMove {
        public Down() {
            super(-1, 0);
        }
    }
}

