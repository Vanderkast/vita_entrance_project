package com.vanderkast.vita_entrance_project.impl.actions;

public class OutOfBoundsException extends RuntimeException {
    private final int y;
    private final int x;

    public OutOfBoundsException(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public String getMessage() {
        return "No tiles in (" + y + " ; " + x + ")\n\t!!!Speedrunners not allowed!!!";
    }
}