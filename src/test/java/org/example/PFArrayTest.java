package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class PFArrayTest {
    private final PFArray array = new PFArray();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void createArrayManually() {
        array.createArrayManually("1,2,3");
        int[] expectedArray = {1, 2, 3};
        assertArrayEquals(expectedArray, array.getArray());
    }

    @Test
    void createArrayManually_invalidInput() {
        array.createArrayManually("hello");
        int[] expectedArray = new int[0];
        assertArrayEquals(expectedArray, array.getArray());
    }
    @Test
    void createRandomArray() {
        array.createRandomArray();
        int[] actualArray = array.getArray();
        assertTrue(actualArray.length > 0 && actualArray.length <= 10);
        for (int num : actualArray) {
            assertTrue(num >= -100 && num <= 100);
        }
    }

    @Test
    void getArray() {
        int[] expectedArray = {1, 2, 3};
        array.createArrayManually("1,2,3");
        assertArrayEquals(expectedArray, array.getArray());
    }

    @Test
    void printArray() {
        array.createArrayManually("1,2,3");
        array.printArray();
        String expectedOutput = "[1, 2, 3]\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void addNumber() {
        array.addNumber(5);
        int[] expectedArray = {5};
        assertArrayEquals(expectedArray, array.getArray());
    }

    @Test
    void findMaxNumber() {
        try {
            array.findMaxNumber();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            assertEquals("In empty array, is impossible to find a max number.", e.getMessage());
        }
            array.createArrayManually("1,2,3,4,5");
            assertEquals(5, array.findMaxNumber());
    }

    @Test
    void findMinNumber() {
        try {
            array.findMinNumber();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            assertEquals("In empty array, is impossible to find a min number.", e.getMessage());
        }
        array.createArrayManually("1,2,3,4,5");
        assertEquals(1, array.findMinNumber());
    }

    @Test
    void removeNumber() {
        array.createArrayManually("1,2,3,4,5");
        int numberToRemove = 3;
        array.removeNumber(numberToRemove, true);
        int[] expectedArray = {1, 2, 4, 5};
        assertArrayEquals(expectedArray, array.getArray());
    }

    @Test
    void removeNumber_notFound() {
        array.createArrayManually("1,2,3,4,5");
        int numberToRemove = 6;
        int[] expectedArray = {1, 2, 3, 4, 5};

        array.removeNumber(numberToRemove, true);
        assertArrayEquals(expectedArray, array.getArray());
        }


    @Test
    public void removeNumber_RemoveAllOfSelectedNum() {
        array.createArrayManually("1,2,2,3,4,2,5");
        array.removeNumber( 2, false);
        int[] expectedArray = {1, 3, 4, 5};
        assertArrayEquals(expectedArray, array.getArray());
    }

    @Test
    void findOccurencyOfNumber() {
        array.createArrayManually("1,2,2,3,3,3,4,4,4,4");
        int occurrences = array.findOccurencyOfNumber(array.getArray(), 3);
        assertEquals(3, occurrences);
    }

    @Test
    void removeAllNumbers() {
        array.createArrayManually("1,2,3");
        array.removeAllNumbers();
        int[] expectedArray = {};
        assertArrayEquals(expectedArray, array.getArray());
    }

    @Test
    void regenerateNumbers() {
        array.createArrayManually("1,2,3");
        int[] originalArray = array.getArray();
        array.regenerateNumbers();
        int[] newArray = array.getArray();
        assertArrayEquals(originalArray, newArray);
    }

    @Test
    void sumOfElements() {
        array.createArrayManually("1,2,3,4,5");
        assertEquals(15, array.sumOfElements());
    }
}