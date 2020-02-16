package com.vanderkast.vita_entrance_project.impl.actions;

import com.vanderkast.vita_entrance_project.game.Action;
import com.vanderkast.vita_entrance_project.game.Stage;

public interface ActionHandler {
    Action askCurrentUserForAction(Stage stage);
}
