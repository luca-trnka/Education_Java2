package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Mock
    private PFArray mockArray;

    private ByteArrayInputStream testIn;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        System.setErr(originalOut);
    }

    @Test
    void testCreateNewArrayOption2() {
        //Set up input for the method being tested
        String input = "1\n1,2,3\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        Main.createNewArray();
        //Normalize line endings in expected and actual outputs
        String expectedOutput = Menu.creationMenuToString()  +
                "Choose an option: Enter numbers separated by commas (f.e. \"1,2,3\"): \r\n" +
                "Array created manually.";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
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

        Main.yourArrays(mockArrays);

        assertEquals(1, mockArrays.size());
        assertArrayEquals(sampleArray.getArray(), mockArrays.get(0).getArray());

       /* String expectedOutput = "Choose the array to work with:\r\n" +
                                "1. Array [1, 2, 3]\r\n" +
                                "Enter the option(1): " +
                                "You've decided to work with: 1\r\n" +
                                Menu.selectedArrayMenuToString() +
                                "Choose an option: ";
        assertEquals(expectedOutput, outContent.toString().trim()); */
    }



}
