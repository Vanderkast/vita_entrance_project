package com.vanderkast.vita_entrance_project.impl.actions;

import com.vanderkast.vita_entrance_project.game.Action;
import com.vanderkast.vita_entrance_project.game.Player;
import com.vanderkast.vita_entrance_project.game.Stage;
import com.vanderkast.vita_entrance_project.game.tiles.Figure;
import com.vanderkast.vita_entrance_project.game.tiles.Tile;

import java.util.ArrayList;
import java.util.List;

public class ActionHandlerImpl implements ActionHandler {
    @Override
    public Action askCurrentUserForAction(Stage stage) {
        String name = stage.getPlayers().get(stage.currentPlayer()).toString();
        List<Action> possibleActions = findAllPossibleActions(stage);
        return null;
    }

    private List<Action> findAllPossibleActions(Stage stage) {
        final List<Action> actions = new ArrayList<>();
        Class userFigure = stage.getPlayers().get(stage.currentPlayer()).getClass();
        for (int y = 0; y < stage.getMap().getAll().size(); y++) {
            for (int x = 0; x < stage.getMap().getAll().get(y).size(); x++) {
                Tile tile = stage.getMap().getAll().get(y).get(x);
                if (tile.getClass().equals(userFigure)) {
                    final int finalX = x;
                    final int finalY = y;
                    ((Figure) tile).getActions().forEach(action -> {
                        if (action.isAvailableFor(stage, finalY, finalX))
                            actions.add(action);
                    });
                }
            }
        }
        return actions;
    }
}
