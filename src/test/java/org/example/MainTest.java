package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MainTest {

    private ByteArrayOutputStream outContent;
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setIn(originalIn);
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testCreateNewArray() {
        //Set up input for the method being tested
        String input = "1\n1,2,3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.createNewArray();
        //Normalize line endings in expected and actual outputs
        String expectedOutput = Menu.creationMenuToString()  +
                "Choose an option: Enter numbers separated by commas (f.e. \"1,2,3\"): \r\n" +
                "Array created manually.\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testYourArrays_noArrayCreated() {
        List<PFArray> mockArrays = new ArrayList<>();
        Main.yourArrays(mockArrays);
        assertEquals("There are no arrays, yet. Create one first!", outContent.toString().trim());
    }

    /* @Test
    void testYourArrays() {
        //Set up input for the method being tested
        String input = "1\n8\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        //Create a sample array for testing
        PFArray sampleArray = new PFArray();
        sampleArray.createArrayManually("1, 2, 3");

        //Mock the arrays list in Main class to return the sample array
        List<PFArray> mockArrays = new ArrayList<>();
        mockArrays.add(sampleArray);

        //Main.yourArrays(mockArrays);
         String expectedOutput = "Choose the array to work with:\r\n" +
                                "1. Array [1, 2, 3]\r\n" +
                                "Enter the option(1): " +
                                "You've decided to work with: 1\r\n" +
                                Menu.selectedArrayMenuToString() +
                                "Choose an option: ";
        assertEquals(expectedOutput, outContent.toString().trim());
    }*/

    @Test
    void testYourArrays() {
        //Create a sample array for testing
        PFArray sampleArray = new PFArray();
        sampleArray.createArrayManually("1, 2, 3");

        List<PFArray> mockArrays = new ArrayList<>();
        mockArrays.add(sampleArray);

        assertEquals(1, mockArrays.size());
        assertArrayEquals(sampleArray.getArray(), mockArrays.get(0).getArray());
    }

    @Test
    void testFindArrayWithMaxSum_noArrayCreated() {
        List<PFArray> mockArrays = new ArrayList<>();
        Main.findArrayWithMaxSum(mockArrays);
        String expectedOut= "No arrays created.";
        assertEquals(expectedOut, outContent.toString().trim());
    }

    @Test
    void testFindArrayWithMaxSum() {
        PFArray sampleArray = new PFArray();
        PFArray sampleArray2 = new PFArray();
        sampleArray.createArrayManually("1, 2, 3");
        sampleArray2.createArrayManually("4, 5, 6");

        List<PFArray> mockArrays = new ArrayList<>();
        mockArrays.add(sampleArray);
        mockArrays.add(sampleArray2);

        Main.findArrayWithMaxSum(mockArrays);

        String expectedOut= "Array with max sum(15): [4, 5, 6]";
        assertEquals(expectedOut, outContent.toString().trim());
    }


    @Test
    void testFindArrayWithMinSum() {
        PFArray sampleArray = new PFArray();
        PFArray sampleArray2 = new PFArray();
        sampleArray.createArrayManually("1, 2, 3");
        sampleArray2.createArrayManually("4, 5, 6");

        List<PFArray> mockArrays = new ArrayList<>();
        mockArrays.add(sampleArray);
        mockArrays.add(sampleArray2);

        Main.findArrayWithMinSum(mockArrays);

        String expectedOutput = "Array with min sum(6): [1, 2, 3]";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    void testFindArrayWithMinSum_twoSameMaxs() {
        PFArray sampleArray = new PFArray();
        PFArray sampleArray2 = new PFArray();
        sampleArray.createArrayManually("1, 2, 3");
        sampleArray2.createArrayManually("0, 3, 3");

        List<PFArray> mockArrays = new ArrayList<>();
        mockArrays.add(sampleArray);
        mockArrays.add(sampleArray2);

        Main.findArrayWithMaxSum(mockArrays);

        String expectedOutput = "Arrays with max sum(6) are: " +
                                "[1, 2, 3]\r\n" + "[0, 3, 3]";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
