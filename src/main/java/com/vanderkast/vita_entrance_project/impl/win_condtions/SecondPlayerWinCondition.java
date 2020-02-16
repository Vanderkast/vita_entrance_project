package com.vanderkast.vita_entrance_project.impl.win_condtions;

import com.vanderkast.vita_entrance_project.game.Action;
import com.vanderkast.vita_entrance_project.game.Stage;
import com.vanderkast.vita_entrance_project.game.Move;
import com.vanderkast.vita_entrance_project.impl.tiles.FirstPlayerFigure;
import com.vanderkast.vita_entrance_project.game.tiles.Figure;
import com.vanderkast.vita_entrance_project.game.tiles.Tile;
import com.vanderkast.vita_entrance_project.game.WinCondition;
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
                    return new FigureYX((Figure) tiles.get(y).get(x), y, x);
            }
        }
        return null;
    }
}
