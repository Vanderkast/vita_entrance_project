package com.vanderkast.vita_entrance_project.impl.players;

import com.vanderkast.vita_entrance_project.game.Player;
import com.vanderkast.vita_entrance_project.game.WinCondition;
import com.vanderkast.vita_entrance_project.impl.tiles.FirstPlayerFigure;
import com.vanderkast.vita_entrance_project.impl.win_condtions.FirstPlayerWinCondition;

import java.util.Collections;
import java.util.List;

public class FirstPlayer implements Player {
    private final List<Class> figures = Collections.singletonList(FirstPlayerFigure.class);
    private final WinCondition winCondition = new FirstPlayerWinCondition();

    @Override
    public List<Class> getFigures() {
        return figures;
    }

    @Override
    public WinCondition getWinCondition() {
        return winCondition;
    }
}
