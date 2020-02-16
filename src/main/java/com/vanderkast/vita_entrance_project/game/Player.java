package com.vanderkast.vita_entrance_project.game;

import java.util.List;

public interface Player {
    List<Class> getFigures();

    WinCondition getWinCondition();
}
