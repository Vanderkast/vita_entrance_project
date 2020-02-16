package com.vanderkast.vita_entrance_project;

public interface Action {
    boolean isAvailableFor(Stage stage, int figureY, int figureX);

    void run(Stage stage, int figureY, int figureX);
}
