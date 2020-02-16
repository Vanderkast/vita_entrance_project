package com.vanderkast.vita_entrance_project.impl.tiles;

import com.vanderkast.vita_entrance_project.game.Action;
import com.vanderkast.vita_entrance_project.impl.actions.DiagonalMove;
import com.vanderkast.vita_entrance_project.impl.actions.SimpleMove;
import com.vanderkast.vita_entrance_project.game.tiles.Figure;

import java.util.Arrays;
import java.util.List;

public class SecondPlayerFigure implements Figure {
    private final List<Action> actions =
            Arrays.asList(
                    new SimpleMove.Down(),
                    new DiagonalMove.DownLeft(),
                    new DiagonalMove.DownRight());

    @Override
    public List<Action> getActions() {
        return actions;
    }
}
