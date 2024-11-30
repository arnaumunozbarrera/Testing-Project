package test.java.cat.uab.tqs.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.cat.uab.tqs.view.MessageView;

class MessageViewTest {

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
    void testShowMessageStatement1() {
        MessageView messageView = new MessageView();
        
        String message = "Test message";
        
        messageView.showMessage(message);
        
        assertEquals(message + System.lineSeparator(), outputStream.toString());
    }

    @Test
    void testShowMessage_EmptyMessageStatement2() {
        MessageView messageView = new MessageView();
        
        String message = "";
        
        messageView.showMessage(message);
        
        assertEquals(message + System.lineSeparator(), outputStream.toString());
    }
}