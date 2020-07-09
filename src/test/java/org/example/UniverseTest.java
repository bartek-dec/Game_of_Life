package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniverseTest {

    private final String[][] array = {{"O", "O", " ", "O", "O"},
            {"O", "O", " ", " ", "O"},
            {" ", " ", "O", " ", " "},
            {"O", "O", " ", "O", "O"},
            {"O", "O", " ", "O", "O"}};

    private Universe universe;

    @BeforeEach
    void setUp() {
        universe = new Universe();
        universe.setState(array);
    }

    @Test
    void getAlive() {
        assertEquals(4, universe.getAlive());
    }
}