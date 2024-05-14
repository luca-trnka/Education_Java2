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

}
