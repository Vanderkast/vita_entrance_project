package com.vanderkast.vita_entrance_project.win_conditions;

import com.vanderkast.vita_entrance_project.Action;
import com.vanderkast.vita_entrance_project.Stage;
import com.vanderkast.vita_entrance_project.actions.Move;
import com.vanderkast.vita_entrance_project.tiles.FirstPlayerFigure;
import com.vanderkast.vita_entrance_project.tiles.Tile;
import jdk.internal.jline.internal.Nullable;

import java.util.List;
import java.util.Optional;

/**
 * Second player wins if First player's figure has no possible move actions.
 */
public class SecondPlayerWinCondition implements WinCondition {
    @Override
    public boolean isStageVictorious(Stage stage) {
        FigureYX firstPlayer =
                Optional.ofNullable(findFirstPlayerFigure(stage.getMap().getAll()))
                        .orElseThrow(NoFirstPlayerFoundException::new);
        for (Action action : firstPlayer.figure.getActions()) {
            if (action instanceof Move)
                action.isAvailableFor(stage, firstPlayer.y, firstPlayer.x);
        }
        return false;
    }

    private @Nullable FigureYX findFirstPlayerFigure(List<List<Tile>> tiles) {
        List<Tile> horizontal;
        Tile tile;
        for (int y = 0; y < tiles.size(); y++) {
            horizontal = tiles.get(y);
            for (int x = 0; x < horizontal.size(); x++) {
                tile = horizontal.get(x);
                if (tile instanceof FirstPlayerFigure)
                    return new FigureYX(tiles.get(y).get(x), y, x);
            }
        }
        return null;
    }

    public static class NoFirstPlayerFoundException extends RuntimeException {

    }
}
