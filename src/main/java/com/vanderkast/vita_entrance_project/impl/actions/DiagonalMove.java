package com.vanderkast.vita_entrance_project.impl.actions;

import com.vanderkast.vita_entrance_project.game.Stage;
import com.vanderkast.vita_entrance_project.game.tiles.EmptyTile;

public abstract class DiagonalMove extends SimpleMove {
    protected DiagonalMove(int deltaY, int deltaX) {
        super(deltaY, deltaX);
    }

    @Override
    public boolean isAvailableFor(Stage stage, int figureY, int figureX) {
        return super.isAvailableFor(stage, figureY, figureX) && upperTileIsMapEnd(stage, figureY, figureX);
    }

    private boolean upperTileIsMapEnd(Stage stage, int figureY, int figureX) {
        return stage.getMap().get(figureY + 1, figureX) instanceof EmptyTile;
    }

    public static class UpLeft extends DiagonalMove {
        public UpLeft() {
            super(1, -1);
        }
    }

    public static class UpRight extends DiagonalMove {
        public UpRight() {
            super(1, 1);
        }
    }

    public static class DownLeft extends DiagonalMove {
        public DownLeft() {
            super(-1, -1);
        }
    }

    public static class DownRight extends DiagonalMove {
        public DownRight() {
            super(-1, 1);
        }
    }
}
