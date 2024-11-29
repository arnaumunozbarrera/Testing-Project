package test.java.cat.uab.tqs.view;

import main.java.cat.uab.tqs.model.BoardModel;
import main.java.cat.uab.tqs.view.BoardView;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        board.setCell(0, 0, board.getSize() ,'s'); 
        board.setCell(1, 1, board.getSize() ,'X'); 
        board.setCell(2, 2, board.getSize() ,'O'); 

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
        board.setCell(0, 0, board.getSize() , 's'); 
        board.setCell(1, 1, board.getSize() ,'X'); 
        board.setCell(2, 2, board.getSize() ,'O'); 

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
		        board.setCell(row, col, board.getSize() , 's');
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
		        board2.setCell(row, col, board.getSize() ,'s');
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
		        board3.setCell(row, col, board.getSize() , 'X');
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
		        board4.setCell(row, col, board.getSize() ,'O');
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
    
    @Test
    void testLoopSimple() {
    	
    	// Considerem board.size max. 8
    	
    	// 1x1 board
    	
        BoardModel board1 = new BoardModel(1, '-', 's', 'X', 'O'); // 1x1 board
        BoardView boardView1 = new BoardView();
        boardView1.printBoard(board1, false);

        String lineSeparator = System.lineSeparator();
        String expectedOutput1 =
                "  1 " + lineSeparator +
                "1 - " + lineSeparator;

        assertEquals(
                expectedOutput1.replace("\r\n", "\n"),
                outputStream.toString().replace("\r\n", "\n")
        );
        
        outputStream.reset();

        // 2x2 board
        BoardModel board2 = new BoardModel(2, '-', 's', 'X', 'O'); // 2x2 board
        board2.setCell(0, 0, board2.getSize(), 's');
        board2.setCell(1, 1, board2.getSize(), 'X');

        BoardView boardView2 = new BoardView();
        boardView2.printBoard(board2, false);

        String expectedOutput2 =
                "  1 2 " + lineSeparator +
                "1 s - " + lineSeparator +
                "2 - X " + lineSeparator;

        assertEquals(
                expectedOutput2.replace("\r\n", "\n"),
                outputStream.toString().replace("\r\n", "\n")
        );
        
        outputStream.reset();

        // 3x3 board
        BoardModel board3 = new BoardModel(3, '-', 's', 'X', 'O'); // 3x3 board
        for (int row = 0; row < board3.getSize(); row++) {
            for (int col = 0; col < board3.getSize(); col++) {
                board3.setCell(row, col, board3.getSize(), 's');
            }
        }

        BoardView boardView3 = new BoardView();
        boardView3.printBoard(board3, false);

        String expectedOutput3 =
                "  1 2 3 " + lineSeparator +
                "1 s s s " + lineSeparator +
                "2 s s s " + lineSeparator +
                "3 s s s " + lineSeparator;

        assertEquals(
                expectedOutput3.replace("\r\n", "\n"),
                outputStream.toString().replace("\r\n", "\n")
        );

        outputStream.reset();
        
        // 6x6 board
        BoardModel board4 = new BoardModel(6, '-', 's', 'X', 'O'); // 6x6 board
        for (int row = 0; row < board4.getSize(); row++) {
            for (int col = 0; col < board4.getSize(); col++) {
                board4.setCell(row, col, board4.getSize(), 's');
            }
        }

        BoardView boardView4 = new BoardView();
        boardView4.printBoard(board4, false);

        String expectedOutput4 =
                "  1 2 3 4 5 6 " + lineSeparator +
                "1 s s s s s s " + lineSeparator +
                "2 s s s s s s " + lineSeparator +
                "3 s s s s s s " + lineSeparator +
                "4 s s s s s s " + lineSeparator +
                "5 s s s s s s " + lineSeparator +
                "6 s s s s s s " + lineSeparator;

        assertEquals(
                expectedOutput4.replace("\r\n", "\n"),
                outputStream.toString().replace("\r\n", "\n")
        );
        
        outputStream.reset();

        // 7x7 board
        BoardModel board5 = new BoardModel(7, '-', 's', 'X', 'O'); // 7x7 board
        for (int row = 0; row < board5.getSize(); row++) {
            for (int col = 0; col < board5.getSize(); col++) {
                board5.setCell(row, col, board5.getSize(), 's');
            }
        }

        BoardView boardView5 = new BoardView();
        boardView5.printBoard(board5, false);

        String expectedOutput5 =
                "  1 2 3 4 5 6 7 " + lineSeparator +
                "1 s s s s s s s " + lineSeparator +
                "2 s s s s s s s " + lineSeparator +
                "3 s s s s s s s " + lineSeparator +
                "4 s s s s s s s " + lineSeparator +
                "5 s s s s s s s " + lineSeparator +
                "6 s s s s s s s " + lineSeparator +
                "7 s s s s s s s " + lineSeparator;

        assertEquals(
                expectedOutput5.replace("\r\n", "\n"),
                outputStream.toString().replace("\r\n", "\n")
        );
        
        outputStream.reset();

        // 8x8 board
        BoardModel board6 = new BoardModel(8, '-', 's', 'X', 'O'); // 8x8 board
        for (int row = 0; row < board6.getSize(); row++) {
            for (int col = 0; col < board6.getSize(); col++) {
                board6.setCell(row, col, board6.getSize(), 's');
            }
        }

        BoardView boardView6 = new BoardView();
        boardView6.printBoard(board6, false);

        String expectedOutput6 =
                "  1 2 3 4 5 6 7 8 " + lineSeparator +
                "1 s s s s s s s s " + lineSeparator +
                "2 s s s s s s s s " + lineSeparator +
                "3 s s s s s s s s " + lineSeparator +
                "4 s s s s s s s s " + lineSeparator +
                "5 s s s s s s s s " + lineSeparator +
                "6 s s s s s s s s " + lineSeparator +
                "7 s s s s s s s s " + lineSeparator +
                "8 s s s s s s s s " + lineSeparator;

        assertEquals(
                expectedOutput6.replace("\r\n", "\n"),
                outputStream.toString().replace("\r\n", "\n")
        );
        
        outputStream.reset();
    }  
    
    
    @Test
    void testLoopsNotSimples() {
    	
        // Crear una matriz 8x8 para simular el grid
    	
        char[][] mockGrid = new char[8][8]; // Matriz 8x8
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mockGrid[i][j] = '-'; // Rellenar la matriz con valores por defecto
            }
        }

        // Crear un mock de BoardModel
        BoardModel mockBoard = mock(BoardModel.class);

        when(mockBoard.getGrid()).thenReturn(mockGrid);
        when(mockBoard.getSize()).thenReturn(8); // Tamaño 8x8
        when(mockBoard.getShipChar()).thenReturn('S'); // Simular un carácter para los barcos
        when(mockBoard.getCell(0, 0)).thenReturn('-'); // Simulación de celdas
        when(mockBoard.getWater(0, 0)).thenReturn('-'); // Simulación de agua

        BoardView boardView = new BoardView();

        // Ejecutar el método printBoard con hideShips = false
        boardView.printBoard(mockBoard, false);

        // Verificar que se haya invocado el método getGrid() exactamente 1 vez
        verify(mockBoard, times(1)).getGrid();
      
    }
    
}