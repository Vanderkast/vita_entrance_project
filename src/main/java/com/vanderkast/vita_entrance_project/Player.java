package com.vanderkast.vita_entrance_project;

import com.vanderkast.vita_entrance_project.win_conditions.WinCondition;

public interface Player {
    char getIcon();

    WinCondition getWinCondition();
}
