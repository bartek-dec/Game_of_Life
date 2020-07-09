package org.example.util;

import java.util.Random;

public class ArrayUtil {

    private final int size = 100;
    private Random random;

    public ArrayUtil(Random random) {
        this.random = random;
    }

    public String[][] initiateArray() {
        String[][] firstState = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (random.nextBoolean()) {
                    firstState[i][j] = Cell.ALIVE.getState();
                } else {
                    firstState[i][j] = Cell.DEAD.getState();
                }
            }
        }
        return firstState;
    }

    public String[][] expandArray(String[][] array) {
        String[][] expanded = new String[array.length + 2][array.length + 2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                expanded[i + 1][j + 1] = array[i][j];
            }
        }

        for (int k = 0; k < array.length; k++) {
            expanded[0][k + 1] = array[array.length - 1][k];
            expanded[expanded.length - 1][k + 1] = array[0][k];
        }

        for (int l = 0; l < array.length; l++) {
            expanded[l + 1][0] = array[l][array.length - 1];
            expanded[l + 1][expanded.length - 1] = array[l][0];
        }

        expanded[0][0] = array[array.length - 1][array.length - 1];
        expanded[expanded.length - 1][expanded.length - 1] = array[0][0];
        expanded[0][expanded.length - 1] = array[array.length - 1][0];
        expanded[expanded.length - 1][0] = array[0][array.length - 1];

        return expanded;
    }

    public String[][] adjustBorders(String[][] array) {
        for (int k = 0; k < array.length; k++) {
            array[0][k] = array[array.length - 2][k];
            array[array.length - 1][k] = array[1][k];
        }

        for (int l = 0; l < array.length; l++) {
            array[l][0] = array[l][array.length - 2];
            array[l][array.length - 1] = array[l][1];
        }

        array[0][0] = array[array.length - 2][array.length - 2];
        array[array.length - 1][array.length - 1] = array[1][1];
        array[0][array.length - 1] = array[array.length - 2][1];
        array[array.length - 1][0] = array[1][array.length - 2];

        return array;
    }
}
