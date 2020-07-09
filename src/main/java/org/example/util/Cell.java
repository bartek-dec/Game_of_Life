package org.example.util;

public enum Cell {
    ALIVE("O"),
    DEAD(" ");

    private String state;

    Cell(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
