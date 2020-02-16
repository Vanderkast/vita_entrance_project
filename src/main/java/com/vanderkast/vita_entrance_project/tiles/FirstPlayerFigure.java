package com.vanderkast.vita_entrance_project.tiles;

import com.vanderkast.vita_entrance_project.Action;
import com.vanderkast.vita_entrance_project.actions.DiagonalMove;
import com.vanderkast.vita_entrance_project.actions.SimpleMove;

import java.util.Arrays;
import java.util.List;

public class FirstPlayerFigure implements Figure {
    private final List<Action> actions =
            Arrays.asList(
                    new SimpleMove.Up(),
                    new DiagonalMove.UpLeft(),
                    new DiagonalMove.UpRight());

    @Override
    public List<Action> getActions() {
        return actions;
    }
}
