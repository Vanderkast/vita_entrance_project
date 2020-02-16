package com.vanderkast.vita_entrance_project.win_conditions;

import com.vanderkast.vita_entrance_project.Stage;
import com.vanderkast.vita_entrance_project.tiles.Figure;
import com.vanderkast.vita_entrance_project.tiles.SecondPlayerFigure;
import com.vanderkast.vita_entrance_project.tiles.Tile;
import jdk.internal.jline.internal.Nullable;

import java.util.*;

/**
 * First player wins if every Second player's figures are higher then their
 */
public class FirstPlayerWinCondition implements WinCondition {
//    private final Character firstPlayer = 'f';
//    private final Character secondPlayer = 's';

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
        for (int spfY: secondPlayerFigureVerticals){
            if(spfY > firstPlayerFigureVertical)
                return false;
        }
        return true;
    }

    /* private @Nullable Map<Character, List<FigureYX>> findPlayersFigures(List<List<Tile>> tiles) {
        List<FigureYX> secondPlayerFigures = new ArrayList<>(3);
        FigureYX firstPlayerFigure = null;

        List<Tile> horizontal;
        Tile tile;
        for (int y = 0; y < tiles.size(); y++) {
            horizontal = tiles.get(y);
            for (int x = 0; x < horizontal.size(); x++) {
                tile = horizontal.get(x);
                if (tile instanceof SecondPlayerFigure)
                    secondPlayerFigures.add(new FigureYX((Figure) tile, y, x));

                if (tile instanceof FirstPlayerWinCondition)
                    firstPlayerFigure = new FigureYX((Figure) tile, y, x);
            }
        }
        Map<Character, List<FigureYX>> result = new HashMap<>(2);
        result.put(firstPlayer, Collections.singletonList(firstPlayerFigure));
        result.put(secondPlayer, secondPlayerFigures);
        return result;
    }*/
}
