package test.java.cat.uab.tqs.view;

import main.java.cat.uab.tqs.model.BoardModel;
import main.java.cat.uab.tqs.view.BoardView;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BoardViewTest {

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
    void testPrintBoardWithHiddenShips() {
    	
    	// Primera versió de prova 
        
        BoardModel board = new BoardModel(4, '-', 's', 'X', 'O');
        board.setCell(0, 0, 's'); 
        board.setCell(1, 1, 'X'); 
        board.setCell(2, 2, 'O'); 

        BoardView boardView = new BoardView();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        boardView.printBoard(board, true);

        System.setOut(System.out);

        String lineSeparator = System.lineSeparator();
        String expectedOutput = 
                "  1 2 3 4 " + lineSeparator +
                "1 - - - - " + lineSeparator +
                "2 - X - - " + lineSeparator +
                "3 - - O - " + lineSeparator +
                "4 - - - - " + lineSeparator;

        assertEquals(
            expectedOutput.replace("\r\n", "\n"), 
            outputStream.toString().replace("\r\n", "\n")
        );
        
        // Segona versió de prova 
    }


    @Test
    void testPrintBoardWithVisibleShips() {
    	
    	// Primera versió de prova 
    	
    	BoardModel board = new BoardModel(4, '-', 's', 'X', 'O');
        board.setCell(0, 0, 's'); 
        board.setCell(1, 1, 'X'); 
        board.setCell(2, 2, 'O'); 

        BoardView boardView = new BoardView();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        boardView.printBoard(board, false);

        System.setOut(System.out);

        String lineSeparator = System.lineSeparator();
        String expectedOutput = 
                "  1 2 3 4 " + lineSeparator +
                "1 s - - - " + lineSeparator +
                "2 - X - - " + lineSeparator +
                "3 - - O - " + lineSeparator +
                "4 - - - - " + lineSeparator;

        assertEquals(
            expectedOutput.replace("\r\n", "\n"), 
            outputStream.toString().replace("\r\n", "\n")
        );
        
        // Segona versió de prova 
    }

    @Test
    void testPrintEmptyBoard() {
    	
   	 	// Primera versió de prova 
    	
   	 	// Primera prova (Ships visibles)
    	
    	BoardModel board = new BoardModel(4, '-', 's', 'X', 'O');

        BoardView boardView = new BoardView();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        boardView.printBoard(board, true);

        System.setOut(System.out);

        String lineSeparator = System.lineSeparator();
        String expectedOutput = 
                "  1 2 3 4 " + lineSeparator +
                "1 - - - - " + lineSeparator +
                "2 - - - - " + lineSeparator +
                "3 - - - - " + lineSeparator +
                "4 - - - - " + lineSeparator;

        assertEquals(
            expectedOutput.replace("\r\n", "\n"), 
            outputStream.toString().replace("\r\n", "\n")
        );
        
   	 	// Segona prova (Ships no visibles)
        
        BoardModel board2 = new BoardModel(4, '-', 's', 'X', 'O');

        BoardView boardView2 = new BoardView();

        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream2));

        boardView2.printBoard(board2, true);

        System.setOut(System.out);

        String lineSeparator2 = System.lineSeparator();
        String expectedOutput2 = 
                "  1 2 3 4 " + lineSeparator2 +
                "1 - - - - " + lineSeparator2 +
                "2 - - - - " + lineSeparator2 +
                "3 - - - - " + lineSeparator2 +
                "4 - - - - " + lineSeparator2;

        assertEquals(
            expectedOutput2.replace("\r\n", "\n"), 
            outputStream2.toString().replace("\r\n", "\n")
        );
        
   	 	// Segona versió de prova 

    }

    @Test
    void testPrintFullBoard() {
    	
    	// Primera versió de prova 
    	
      	 // Primera prova (Ships a tot el board, ships visibles)
    	
	    	BoardModel board = new BoardModel(4, '-', 's', 'X', 'O');
	        for (int row = 0; row < board.getSize(); row++) {
	            for (int col = 0; col < board.getSize(); col++) {
	                board.setCell(row, col, 's');
	            }
	        }
	        
	        BoardView boardView = new BoardView();

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));

	        boardView.printBoard(board, false);

	        System.setOut(System.out);

	        String lineSeparator = System.lineSeparator();
	        String expectedOutput = 
	                "  1 2 3 4 " + lineSeparator +
	                "1 s s s s " + lineSeparator +
	                "2 s s s s " + lineSeparator +
	                "3 s s s s " + lineSeparator +
	                "4 s s s s " + lineSeparator;

	        assertEquals(
	            expectedOutput.replace("\r\n", "\n"), 
	            outputStream.toString().replace("\r\n", "\n")
	        );
	        
      	 // Segona prova (Ships a tot el board, ships no visibles)

	        BoardModel board2 = new BoardModel(4, '-', 's', 'X', 'O');
	        for (int row = 0; row < board2.getSize(); row++) {
	            for (int col = 0; col < board2.getSize(); col++) {
	                board2.setCell(row, col, 's');
	            }
	        }
	        
	        BoardView boardView2 = new BoardView();

	        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream2));

	        boardView2.printBoard(board2, true);

	        System.setOut(System.out);

	        String lineSeparator2 = System.lineSeparator();
	        String expectedOutput2 = 
	                "  1 2 3 4 " + lineSeparator2 +
	                "1 - - - - " + lineSeparator2 +
	                "2 - - - - " + lineSeparator2 +
	                "3 - - - - " + lineSeparator2 +
	                "4 - - - - " + lineSeparator2;

	        assertEquals(
	            expectedOutput2.replace("\r\n", "\n"), 
	            outputStream2.toString().replace("\r\n", "\n")
	        );
    	
     	 // Tercera prova (Hits a tot el board)
	        
	        BoardModel board3 = new BoardModel(4, '-', 's', 'X', 'O');
	        for (int row = 0; row < board3.getSize(); row++) {
	            for (int col = 0; col < board3.getSize(); col++) {
	                board3.setCell(row, col, 'X');
	            }
	        }
	        
	        BoardView boardView3 = new BoardView();

	        ByteArrayOutputStream outputStream3 = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream3));

	        boardView3.printBoard(board3, false);

	        System.setOut(System.out);

	        String lineSeparator3 = System.lineSeparator();
	        String expectedOutput3 = 
	                "  1 2 3 4 " + lineSeparator3 +
	                "1 X X X X " + lineSeparator3 +
	                "2 X X X X " + lineSeparator3 +
	                "3 X X X X " + lineSeparator3 +
	                "4 X X X X " + lineSeparator3;

	        assertEquals(
	            expectedOutput3.replace("\r\n", "\n"), 
	            outputStream3.toString().replace("\r\n", "\n")
	        );

     	 // Quarta prova (Misses a tot el board)
	        
	        BoardModel board4 = new BoardModel(4, '-', 's', 'X', 'O');
	        for (int row = 0; row < board4.getSize(); row++) {
	            for (int col = 0; col < board4.getSize(); col++) {
	                board4.setCell(row, col, 'O');
	            }
	        }
	        
	        BoardView boardView4 = new BoardView();

	        ByteArrayOutputStream outputStream4 = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream4));

	        boardView4.printBoard(board4, false);

	        System.setOut(System.out);

	        String lineSeparator4 = System.lineSeparator();
	        String expectedOutput4 = 
	                "  1 2 3 4 " + lineSeparator4 +
	                "1 O O O O " + lineSeparator4 +
	                "2 O O O O " + lineSeparator4 +
	                "3 O O O O " + lineSeparator4 +
	                "4 O O O O " + lineSeparator4;

	        assertEquals(
	            expectedOutput4.replace("\r\n", "\n"), 
	            outputStream4.toString().replace("\r\n", "\n")
	        );
	        
	     // Segona versió de prova 
    }
}
