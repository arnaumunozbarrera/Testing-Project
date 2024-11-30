package test.java.cat.uab.tqs.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void testgetIntInputStatement() {
    	
    	// Input invàlid segons i desprès un input vàlid segons una matriu 4x4
        
        String simulatedInput = "a\n1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InputView inputView = new InputView();

        inputView.getIntInput("Enter a number: ");
        String output = outputStream.toString();

        assertTrue(output.contains("Invalid input. Please enter an integer."));        
    }
    
    @Test
    void testValidInputsParticionsEquivalentsAndValorsLimitAndFrontera() {
    	
    	// Inputs vàlid segons una matriu 4x4
    	
        String simulatedInput = "2\n0\n3\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InputView inputView = new InputView();

        assertEquals(2, inputView.getIntInput("Enter a number: "));
        assertEquals(0, inputView.getIntInput("Enter a number: "));
        assertEquals(3, inputView.getIntInput("Enter a number: "));
    }

    @Test
    void testOutOfRangeInputsParticionsEquivalentsAndValorsLimitAndFrontera() {
    	
    	// Inputs no vàlids segons una matriu 4x4
    	
        String simulatedInput = "-1\n4\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InputView inputView = new InputView();

        assertEquals(-1, inputView.getIntInput("Enter a number: "));
        assertEquals(4, inputView.getIntInput("Enter a number: "));  
    }

    @Test
    void testInvalidInputsParticionsEquivalentsAndValorsLimitAndFrontera() {	
    	
        // Inputs no vàlids segons una matriu 4x4, (lletres i decimals) 

        String simulatedInput = "a\nabcd\n3.1415\n2\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        InputView inputView = new InputView();

        //inputView.getIntInput("Enter a number: "); 
        // 'a' -> Invalid
        // 'abcd' -> Invalid
        // '3.1415' -> Invalid
        // '2' -> Valid
        
        // Comprovació de seleccionar l'únic valor valid entre els inputs
        
        assertEquals(2, inputView.getIntInput("Enter a number: "));
        
        String output = outputStream.toString();

        assertTrue(output.contains("Invalid input. Please enter an integer."));
        
    }
}