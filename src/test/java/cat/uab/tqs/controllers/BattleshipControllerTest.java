package test.java.cat.uab.tqs.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.cat.uab.tqs.controller.BattleshipController;
import main.java.cat.uab.tqs.model.BoardModel;
import main.java.cat.uab.tqs.view.BoardView;
import main.java.cat.uab.tqs.view.InputView;
import main.java.cat.uab.tqs.view.MessageView;
import main.java.cat.uab.tqs.view.MockInputView;
import main.java.cat.uab.tqs.view.MockMessageView;
import main.java.cat.uab.tqs.model.BoardModel;

class BattleshipControllerTest {

	@Test
	void testPlaceShipsStatement() {
		
		//Statement Coverage:
		
		// 1. Caselles vàlides
		
		BoardModel board1 = new BoardModel(4, '-', 'S', 'X', 'O');
		BoardView boardView1 = new BoardView();
		String name1 = "prova";
		MockInputView inputView1 = new MockInputView(new int[] {1,1});
		MockMessageView messageView1 = new MockMessageView();
		BattleshipController game1 = new BattleshipController(board1, boardView1, inputView1, messageView1, name1);
		
		game1.placeShips(1);
		assertEquals('S', board1.getCell(0, 0));
		
		// 2. Coordenades no vàlides
		
		BoardModel board2 = new BoardModel(4, '-', 'S', 'X', 'O');
		BoardView boardView2 = new BoardView();
		String name2 = "prova";
		MockInputView inputView2 = new MockInputView(new int[] {6,6,1,1}); 
		MockMessageView messageView2 = new MockMessageView();
		BattleshipController game2 = new BattleshipController(board2, boardView2, inputView2, messageView2, name2);
		
		game2.placeShips(1);
		assertTrue(messageView2.containsMessage("Coordinates out of bounds. Try again."));
		assertEquals('S', board2.getCell(0, 0));

		
		// 3. Casella ja feta servir
		
		BoardModel board3 = new BoardModel(4, '-', 'S', 'X', 'O');
		BoardView boardView3 = new BoardView();
		String name3 = "prova";
		MockInputView inputView3 = new MockInputView(new int[] {1,1,1,1,2,2}); // Afegim (1,1), tornem a intentar afegir (1,1) i s'afegeix de nou
		MockMessageView messageView3 = new MockMessageView();
		BattleshipController game3 = new BattleshipController(board3, boardView3, inputView3, messageView3, name3);
		
		game3.placeShips(2);
		assertTrue(messageView3.containsMessage("Cell already occupied. Try again."));
		
	}
	
	@Test
	void testPlaceShipsStatement2() {
		
		//Statement Coverage:
		
		// 1. Caselles vàlides
		
	    BoardModel board1 = new BoardModel(4, '-', 'S', 'X', 'O');
	    BoardView boardView1 = new BoardView();
	    String name1 = "prova";
	    MockInputView inputView1 = new MockInputView(new int[] {1, 1});
	    MockMessageView messageView1 = new MockMessageView();
	    BattleshipController game1 = new BattleshipController(board1, boardView1, inputView1, messageView1, name1);

	    game1.placeShips2(1);
	    assertEquals('S', board1.getCell(0, 0));

	    // 2. Coordenades no vàlides
	    
	    BoardModel board2 = new BoardModel(4, '-', 'S', 'X', 'O');
	    BoardView boardView2 = new BoardView();
	    String name2 = "prova";
	    MockInputView inputView2 = new MockInputView(new int[] {6, 6, 1, 1}); 
	    MockMessageView messageView2 = new MockMessageView();
	    BattleshipController game2 = new BattleshipController(board2, boardView2, inputView2, messageView2, name2);

	    game2.placeShips2(1);
	    assertTrue(messageView2.containsMessage("Coordinates out of bounds. Try again."));
	    assertEquals('S', board2.getCell(0, 0));

		// 3. Casella ja feta servir

	    BoardModel board3 = new BoardModel(4, '-', 'S', 'X', 'O');
	    BoardView boardView3 = new BoardView();
	    String name3 = "prova";
	    MockInputView inputView3 = new MockInputView(new int[] {1, 1, 1, 1, 2, 2}); 
	    MockMessageView messageView3 = new MockMessageView();
	    BattleshipController game3 = new BattleshipController(board3, boardView3, inputView3, messageView3, name3);

	    game3.placeShips2(2);
	    assertTrue(messageView3.containsMessage("Cell already occupied. Try again."));
	    assertEquals('S', board3.getCell(0, 0));
	    assertEquals('S', board3.getCell(1, 1));
	}
	
	@Test
	void testTakeTurnStatement() {
		
		// 1. Jugada amb èxit
		
		BoardModel board1 = new BoardModel(4, '-', 'S', 'X', 'O');
		BoardView boardView1 = new BoardView();
		String name1 = "prova";
		MockInputView inputView1 = new MockInputView(new int[] {1,1});
		MockMessageView messageView1 = new MockMessageView();
		BattleshipController game1 = new BattleshipController(board1, boardView1, inputView1, messageView1, name1);
		
		board1.setCell(0, 0, board1.getSize(), 'S');
		int result1 = game1.takeTurn();
		
		assertEquals(1, result1);
		assertEquals('X',board1.getCell(0, 0));
		assertTrue(messageView1.containsMessage("Hit!"));
		
		// 2. Miss (casella buïda)
		
		BoardModel board2 = new BoardModel(4, '-', 'S', 'X', 'O');
		BoardView boardView2 = new BoardView();
		String name2 = "prova";
		MockInputView inputView2 = new MockInputView(new int[] {2,2}); 
		MockMessageView messageView2 = new MockMessageView();
		BattleshipController game2 = new BattleshipController(board2, boardView2, inputView2, messageView2, name2);
		
		int result2= game2.takeTurn();
		assertEquals(0,result2);
		assertEquals('O', board2.getCell(1, 1));
		assertTrue(messageView2.containsMessage("Miss!"));
		
		// 3. Casella ja feta servir per ship ja descobert 
		
		BoardModel board3 = new BoardModel(4, '-', 'S', 'X', 'O');
		BoardView boardView3 = new BoardView();
		String name3 = "prova";
		MockInputView inputView3 = new MockInputView(new int[] {1,1,2,2}); //Primer afegim (1,1)
		MockMessageView messageView3 = new MockMessageView();
		BattleshipController game3 = new BattleshipController(board3, boardView3, inputView3, messageView3, name3);
		
		board3.setCell(0, 0, board3.getSize(), 'X');
		int result3 = game3.takeTurn();
		
		assertEquals(0,result3);
		assertEquals('X', board3.getCell(0, 0));
		assertEquals('O', board3.getCell(1, 1));
		assertTrue(messageView3.containsMessage("Already targeted. Try again."));
		assertTrue(messageView3.containsMessage("Miss!"));
		
		// 4. Casella ja feta servir per Miss previ 
		
		BoardModel board4 = new BoardModel(4, '-', 'S', 'X', 'O');
		BoardView boardView4 = new BoardView();
		String name4 = "prova";
		MockInputView inputView4 = new MockInputView(new int[] {1,1,2,2});
		MockMessageView messageView4 = new MockMessageView();
		BattleshipController game4 = new BattleshipController(board4, boardView4, inputView4, messageView4, name4);
		
		board4.setCell(0, 0, board4.getSize(), 'O');
		int result4 = game4.takeTurn();
		
		assertEquals(0,result4);
		assertEquals('O', board4.getCell(0, 0));
		assertEquals('O', board3.getCell(1, 1));
		assertTrue(messageView4.containsMessage("Already targeted. Try again."));
		assertTrue(messageView4.containsMessage("Miss!"));
		
	}
	
	@Test
    void testPlaceShipsLoopSimple() {
		
		// 1. Placement d'un ship correctament
		
	    BoardModel board1 = new BoardModel(4, '-', 'S', 'X', 'O');
	    
	    BoardView boardView1 = new BoardView();
	    String name1 = "prova";
	    MockInputView inputView1 = new MockInputView(new int[] {1,1}); // Coloca el barco en (1,1)
	    MockMessageView messageView1 = new MockMessageView();
	    BattleshipController game1 = new BattleshipController(board1, boardView1, inputView1, messageView1, name1);
	    
	    game1.placeShips(1);
	    
	    assertEquals('S', board1.getCell(0, 0)); 

	    // 2. Placement d'un ship fora dels limits
	    
	    BoardModel board2 = new BoardModel(4, '-', 'S', 'X', 'O');
	    MockInputView inputView2 = new MockInputView(new int[] {5,5,1,1}); // Primer intent a (5,5), placement final a (1,1)
	    MockMessageView messageView2 = new MockMessageView();
	    BattleshipController game2 = new BattleshipController(board2, boardView1, inputView2, messageView2, name1);

	    game2.placeShips(1);
	    assertTrue(messageView2.containsMessage("Coordinates out of bounds. Try again.")); // Missatge d'error per (5,5)
	    
	    assertEquals('S', board2.getCell(0, 0));

	    // 3. Placement d'un ship a una casella ja feta servir
	    
	    BoardModel board3 = new BoardModel(4, '-', 'S', 'X', 'O');
	    board3.setCell(0, 0, board3.getSize(), 'S'); 
	    MockInputView inputView3 = new MockInputView(new int[] {1,1,2,2}); // Primer intent a (1,1), placement final a (2,2)
	    MockMessageView messageView3 = new MockMessageView();
	    BattleshipController game3 = new BattleshipController(board3, boardView1, inputView3, messageView3, name1);

	    game3.placeShips(1);
	    assertTrue(messageView3.containsMessage("Cell already occupied. Try again.")); // Missatge d'error per casella ocupada
	    
	    assertEquals('S', board3.getCell(0, 0));
	    assertEquals('S', board3.getCell(1, 1));
    } 
	
	
	@Test
	void testPlaceShipsLoopSimple2() {

		// 1. Placement d'un ship correctament
		
	    BoardModel board1 = new BoardModel(4, '-', 'S', 'X', 'O');
	    BoardView boardView1 = new BoardView();
	    String name1 = "prova";
	    MockInputView inputView1 = new MockInputView(new int[]{1, 1}); 
	    MockMessageView messageView1 = new MockMessageView();
	    BattleshipController game1 = new BattleshipController(board1, boardView1, inputView1, messageView1, name1);

	    game1.placeShips2(1);

	    assertEquals('S', board1.getCell(0, 0));

	    // 2. Placement d'un ship fora dels limits
	    
	    BoardModel board2 = new BoardModel(4, '-', 'S', 'X', 'O');
	    MockInputView inputView2 = new MockInputView(new int[]{5, 5, 1, 1}); 
	    MockMessageView messageView2 = new MockMessageView();
	    BattleshipController game2 = new BattleshipController(board2, boardView1, inputView2, messageView2, name1);

	    game2.placeShips2(1);
	    assertTrue(messageView2.containsMessage("Coordinates out of bounds. Try again.")); 
	    assertEquals('S', board2.getCell(0, 0));

	    // 3. Placement d'un ship a una casella ja feta servir
	    
	    BoardModel board3 = new BoardModel(4, '-', 'S', 'X', 'O');
	    board3.setCell(0, 0, board3.getSize(), 'S'); 
	    MockInputView inputView3 = new MockInputView(new int[]{1, 1, 2, 2}); 
	    MockMessageView messageView3 = new MockMessageView();
	    BattleshipController game3 = new BattleshipController(board3, boardView1, inputView3, messageView3, name1);

	    game3.placeShips2(1);
	    assertTrue(messageView3.containsMessage("Cell already occupied. Try again.")); 
	    assertEquals('S', board3.getCell(0, 0));
	    assertEquals('S', board3.getCell(1, 1));
	}
	
	@Test
	void testPlaceShipsPath() {
		
	    MockInputView inputView = new MockInputView(new int[] {
	        5, 5, // Path 1: Coords fora dels límits
	        1, 1, // Path 2: Casella ocupada
	        2, 2  // Path 3: Coords vàlides
	    });
	    
	    MockMessageView messageView = new MockMessageView();
	    BoardModel board = new BoardModel(4, '-', 'S', 'X', 'O');
	    
	    board.setCell(0, 0, board.getSize(), 'S'); // Fem set de la casella (1,1) per pasar pel path de casella ocupada
	
	    BattleshipController game = new BattleshipController(board, new BoardView(), inputView, messageView, "prova");
	
	    game.placeShips(1);
	
	    assertTrue(messageView.containsMessage("Coordinates out of bounds. Try again."));
	    assertTrue(messageView.containsMessage("Cell already occupied. Try again."));
	
	    assertEquals('S', board.getCell(1, 1));
	}
	
	@Test
	void testTakeTurnPath() {

		MockInputView inputView = new MockInputView(new int[] {
	        5, 5, // Path 1: Coords fora dels límit
	        1, 1, // Path 2: Casella ja atacada
	        2, 2, // Path 3.1: Ship hitted
	        3, 3  // Path 3.2: Casella buïda 
	    });
	    MockMessageView messageView = new MockMessageView();
	    BoardModel board = new BoardModel(4, '-', 'S', 'X', 'O');
	    board.setCell(0, 0, board.getSize(), 'X'); // Casella hitted
	    board.setCell(1, 1, board.getSize(), 'S'); // Ships situat a (2,2)

	    BattleshipController game = new BattleshipController(board, new BoardView(), inputView, messageView, "prova");

	    int resultHit = game.takeTurn(); // resultHit = 1
	    int resultMiss = game.takeTurn(); // resultMiss = 0

	    assertTrue(messageView.containsMessage("Coordinates out of bounds. Try again."));
	    assertTrue(messageView.containsMessage("Already targeted. Try again."));
	    assertTrue(messageView.containsMessage("Hit!"));
	    assertTrue(messageView.containsMessage("Miss!"));

	    assertEquals(1, resultHit); 
	    assertEquals(0, resultMiss); 
	}

}
