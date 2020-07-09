package org.example;

import org.example.util.ArrayUtil;
import org.example.util.Cell;

import java.util.Objects;

public class Generation extends Thread {

    private Universe universe;
    private ArrayUtil util;

    public Generation(Universe universe, ArrayUtil util) {
        this.universe = universe;
        this.util = util;
    }

    @Override
    public void run() {
        nextGeneration(universe.getState());
    }

    public void nextGeneration(String[][] state) {
        String[][] nextGen = new String[state.length][state.length];

        int row = state.length;
        int col = state.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if ((i >= 1 && i <= row - 2) && (j >= 1 && j <= col - 2)) {
                    if (Objects.equals(state[i][j], Cell.ALIVE.getState()) && (countNeighbours(i, j, state) >= 2
                            && countNeighbours(i, j, state) <= 3)) {
                        nextGen[i][j] = Cell.ALIVE.getState();
                    } else if (Objects.equals(state[i][j], Cell.DEAD.getState()) && countNeighbours(i, j, state) == 3) {
                        nextGen[i][j] = Cell.ALIVE.getState();
                    } else if ((Objects.equals(state[i][j], Cell.ALIVE.getState()) && (countNeighbours(i, j, state) < 2)) ||
                            (Objects.equals(state[i][j], Cell.ALIVE.getState()) && (countNeighbours(i, j, state) > 3))) {
                        nextGen[i][j] = Cell.DEAD.getState();
                    } else {
                        nextGen[i][j] = state[i][j];
                    }
                } else {
                    nextGen[i][j] = state[i][j];
                }
            }
        }
        universe.setState(util.adjustBorders(nextGen));
    }

    private int countNeighbours(int i, int j, String[][] state) {
        int quantity = 0;

        if (Objects.equals(state[i - 1][j - 1], Cell.ALIVE.getState())) {
            quantity++;
        }
        if (Objects.equals(state[i - 1][j], Cell.ALIVE.getState())) {
            quantity++;
        }
        if (Objects.equals(state[i - 1][j + 1], Cell.ALIVE.getState())) {
            quantity++;
        }
        if (Objects.equals(state[i][j - 1], Cell.ALIVE.getState())) {
            quantity++;
        }
        if (Objects.equals(state[i][j + 1], Cell.ALIVE.getState())) {
            quantity++;
        }
        if (Objects.equals(state[i + 1][j - 1], Cell.ALIVE.getState())) {
            quantity++;
        }
        if (Objects.equals(state[i + 1][j], Cell.ALIVE.getState())) {
            quantity++;
        }
        if (Objects.equals(state[i + 1][j + 1], Cell.ALIVE.getState())) {
            quantity++;
        }

        return quantity;
    }
}
