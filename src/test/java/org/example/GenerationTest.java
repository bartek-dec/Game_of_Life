package org.example;

import org.example.util.ArrayUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GenerationTest {

    @Mock
    private Random random;
    private Universe universe;
    private ArrayUtil util;
    private Generation generation;
    private final String[][] array = {{"O", "O", " ", "O", "O"},
            {"O", "O", " ", "O", "O"},
            {" ", " ", "O", " ", " "},
            {"O", "O", " ", "O", "O"},
            {"O", "O", " ", "O", "O"}};

    @BeforeEach
    void setUp() {
        random = Mockito.mock(Random.class);
        util = new ArrayUtil(random);
        universe = new Universe();
        universe.setState(array);
        generation = new Generation(universe, util);
    }

    @Test
    void nextGeneration() {
        String[][] expected = {{" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}};
        generation.nextGeneration(universe.getState());

        assertArrayEquals(expected, universe.getState());
    }
}