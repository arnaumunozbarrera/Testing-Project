package test.java.cat.uab.tqs.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.cat.uab.tqs.view.InputView;

class InputViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testValidInputs() {
    	
    	// Primera versió de prova 
    	
        // Primera prova (Inputs vàlid segons una matriu 8x8, (0-7)) 
    	
        String simulatedInput = "0\n7\n4\n3\n1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InputView inputView = new InputView();

        assertEquals(0, inputView.getIntInput("Enter a number: "));
        assertEquals(7, inputView.getIntInput("Enter a number: "));
        assertEquals(4, inputView.getIntInput("Enter a number: "));
        assertEquals(3, inputView.getIntInput("Enter a number: "));
        assertEquals(1, inputView.getIntInput("Enter a number: "));
    }

    @Test
    void testOutOfRangeInputs() {
    	
    	// Primera versió de prova 
    	
        // Primera prova (Inputs no vàlids segons una matriu 8x8, (-1, 9, -4, 13)) 
    	
        String simulatedInput = "-1\n9\n-4\n13\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InputView inputView = new InputView();

        assertEquals(-1, inputView.getIntInput("Enter a number: "));
        assertEquals(9, inputView.getIntInput("Enter a number: "));
        assertEquals(-4, inputView.getIntInput("Enter a number: "));
        assertEquals(13, inputView.getIntInput("Enter a number: "));
    }

    @Test
    void testInvalidInputs() {
    	
    	// Primera versió de prova 
    	
        // Primera prova (Inputs no vàlids segons una matriu 8x8, (-lletres i decimals)) 

        String simulatedInput = "a\nabcd\n3.1415\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InputView inputView = new InputView();

        //inputView.getIntInput("Enter a number: "); 
        // 'a' -> Invalid
        // 'abcd' -> Invalid
        // '3.14.15' -> Invalid
        // '5' -> Valid
        
        // Comprovació de seleccionar l'únic valor valid entre els inputs
        
        assertEquals(5, inputView.getIntInput("Enter a number: "));
        
    }
}
