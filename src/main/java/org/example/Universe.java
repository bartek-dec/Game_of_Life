package org.example;

import org.example.util.Cell;

import java.util.Objects;

public class Universe {

    private String[][] state;

    public Universe() {
    }

    public String[][] getState() {
        return state;
    }

    public void setState(String[][] state) {
        this.state = state;
    }

    public int getAlive() {
        if (state != null) {
            int quantity = 0;
            for (int k = 1; k < state.length - 1; k++) {
                for (int j = 1; j < state.length - 1; j++) {
                    if (Objects.equals(state[k][j], Cell.ALIVE.getState())) {
                        quantity++;
                    }
                }
            }
            return quantity;
        }
        return -1;
    }
}
