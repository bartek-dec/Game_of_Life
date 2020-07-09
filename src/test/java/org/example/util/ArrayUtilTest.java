package org.example.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilTest {

    private ArrayUtil util;
    @Mock
    private Random random;

    @BeforeEach
    void setUp() {
        random = Mockito.mock(Random.class);
        util = new ArrayUtil(random);
    }

    @Test
    void initiateArray() {
        assertEquals(100, util.initiateArray().length);
    }

    @Test
    void expandArrayCorrectSize() {
        String[][] array = util.initiateArray();
        assertEquals(102, util.expandArray(array).length);
    }

    @Test
    void expandArrayCorrectContent() {
        String[][] current = {{"O", " ", "O"},
                {" ", "O", " "},
                {"O", " ", "O"}};

        String[][] expected = {{"O", "O", " ", "O", "O"},
                {"O", "O", " ", "O", "O"},
                {" ", " ", "O", " ", " "},
                {"O", "O", " ", "O", "O"},
                {"O", "O", " ", "O", "O"}};

        assertArrayEquals(expected, util.expandArray(current));
    }

    @Test
    void adjustBorders() {
        String[][] current = {{"O", "O", " ", "O", "O"},
                {"O", "O", " ", " ", "O"},
                {" ", " ", "O", " ", " "},
                {"O", "O", " ", "O", "O"},
                {"O", "O", " ", "O", "O"}};

        String[][] expected = {{"O", "O", " ", "O", "O"},
                {" ", "O", " ", " ", "O"},
                {" ", " ", "O", " ", " "},
                {"O", "O", " ", "O", "O"},
                {" ", "O", " ", " ", "O"}};

        assertArrayEquals(expected,util.adjustBorders(current));
    }
}