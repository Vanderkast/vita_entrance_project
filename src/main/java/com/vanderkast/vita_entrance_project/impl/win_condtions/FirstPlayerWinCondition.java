package com.vanderkast.vita_entrance_project.impl.win_condtions;

import com.vanderkast.vita_entrance_project.game.Stage;
import com.vanderkast.vita_entrance_project.game.tiles.Tile;
import com.vanderkast.vita_entrance_project.game.WinCondition;
import com.vanderkast.vita_entrance_project.impl.tiles.SecondPlayerFigure;

import java.util.ArrayList;
import java.util.List;

/**
 * First player wins if every Second player's figures are higher then their
 */
public class FirstPlayerWinCondition implements WinCondition {

    @Override
    public boolean isStageVictorious(Stage stage) {
        List<Integer> secondPlayerFigureVerticals = new ArrayList<>();
        int firstPlayerFigureVertical = -1;
        List<List<Tile>> tiles = stage.getMap().getAll();
        List<Tile> horizontal;
        Tile tile;
        for (int y = 0; y < tiles.size(); y++) {
            horizontal = tiles.get(y);
            for (int x = 0; x < horizontal.size(); x++) {
                tile = horizontal.get(x);
                if (tile instanceof SecondPlayerFigure)
                    secondPlayerFigureVerticals.add(y);
                if (tile instanceof FirstPlayerWinCondition)
                    firstPlayerFigureVertical = y;
            }
        }

        if(firstPlayerFigureVertical == -1 || secondPlayerFigureVerticals.isEmpty())
            throw new NoFirstPlayerFoundException();

        for (int spfY: secondPlayerFigureVerticals){
            if(spfY > firstPlayerFigureVertical)
                return false;
        }
        return true;
    }
}
