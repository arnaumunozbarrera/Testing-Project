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
	void testPlaceShips() {
		
		//Statement Coverage:
		// 1. Casillas vàlidas
		BoardModel board1 = new BoardModel(4, '-', 'S', 'X', 'O');
		BoardView boardView1 = new BoardView();
		String name1 = "prova";
		MockInputView inputView1 = new MockInputView(new int[] {1,1});
		MockMessageView messageView1 = new MockMessageView();
		BattleshipController game1 = new BattleshipController(board1, boardView1, inputView1, messageView1, name1);
		
		game1.placeShips(1);
		assertEquals('S', board1.getCell(0, 0));
		
		// 2. Coordenadas no vàlidas
		BoardModel board2 = new BoardModel(4, '-', 'S', 'X', 'O');
		BoardView boardView2 = new BoardView();
		String name2 = "prova";
		MockInputView inputView2 = new MockInputView(new int[] {6,6,1,1}); 
		MockMessageView messageView2 = new MockMessageView();
		BattleshipController game2 = new BattleshipController(board2, boardView2, inputView2, messageView2, name2);
		
		game2.placeShips(1);
		assertTrue(messageView2.containsMessage("Coordinates out of bounds. Try again."));
		
		// 3. Casilla que ya esta llena
		BoardModel board3 = new BoardModel(4, '-', 'S', 'X', 'O');
		BoardView boardView3 = new BoardView();
		String name3 = "prova";
		MockInputView inputView3 = new MockInputView(new int[] {1,1,1,1,2,2}); //Primer afegim (1,1), despres tornem a intentar afegir (1,1) que no hauria de deixar i afegir 
		MockMessageView messageView3 = new MockMessageView();
		BattleshipController game3 = new BattleshipController(board3, boardView3, inputView3, messageView3, name3);
		
		game3.placeShips(2);
		assertTrue(messageView3.containsMessage("Cell already occupied. Try again."));
		
	}
	
	@Test
	void testTakeTurn() {
		// 1. Tiro con exito 
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
		
		// 2. Fallo (casilla vacia)
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
		
		// 3. Casilla ya targeteada por barco descubierto
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
		
		// 4. Casilla ya fallada
		BoardModel board4 = new BoardModel(4, '-', 'S', 'X', 'O');
		BoardView boardView4 = new BoardView();
		String name4 = "prova";
		MockInputView inputView4 = new MockInputView(new int[] {1,1,2,2}); //Primer afegim (1,1), despres tornem a intentar afegir (1,1) que no hauria de deixar i afegir 
		MockMessageView messageView4 = new MockMessageView();
		BattleshipController game4 = new BattleshipController(board4, boardView4, inputView4, messageView4, name4);
		
		board4.setCell(0, 0, board4.getSize(), 'O');
		int result4 = game4.takeTurn();
		
		assertEquals(0,result4);
		assertEquals('O', board4.getCell(0, 0));
		assertEquals('O', board4.getCell(1, 1));
		assertTrue(messageView4.containsMessage("Already targeted. Try again."));
		assertTrue(messageView4.containsMessage("Miss!"));
	}
	
	@Test
    void testLoopSimple() {
		
		// Caso 1: Colocando un solo barco correctamente
	    BoardModel board1 = new BoardModel(4, '-', 'S', 'X', 'O');
	    
	    BoardView boardView1 = new BoardView();
	    String name1 = "prova";
	    MockInputView inputView1 = new MockInputView(new int[] {1,1}); // Coloca el barco en (1,1)
	    MockMessageView messageView1 = new MockMessageView();
	    BattleshipController game1 = new BattleshipController(board1, boardView1, inputView1, messageView1, name1);
	    
	    game1.placeShips(1);
	    
	    // Verificar que el barco se haya colocado en (1,1)
	    
	    assertEquals('S', board1.getCell(0, 0)); // Las coordenadas internas del tablero son 0,0

	    // Caso 2: Intentando colocar un barco fuera de los límites
	    
	    BoardModel board2 = new BoardModel(4, '-', 'S', 'X', 'O');
	    MockInputView inputView2 = new MockInputView(new int[] {5,5,1,1}); // Primero intenta fuera de límites (5,5), luego coloca en (1,1)
	    MockMessageView messageView2 = new MockMessageView();
	    BattleshipController game2 = new BattleshipController(board2, boardView1, inputView2, messageView2, name1);

	    game2.placeShips(1);
	    assertTrue(messageView2.containsMessage("Coordinates out of bounds. Try again.")); // Debe mostrar mensaje de error para coordenadas fuera de límites

	    // Verificar que el barco se colocó en la posición válida (1,1)
	    
	    assertEquals('S', board2.getCell(0, 0));

	    // Caso 3: Intentando colocar un barco en una casilla ocupada
	    
	    BoardModel board3 = new BoardModel(4, '-', 'S', 'X', 'O');
	    board3.setCell(0, 0, board3.getSize(), 'S'); // Marca (1,1) como ocupada
	    MockInputView inputView3 = new MockInputView(new int[] {1,1,2,2}); // Primero intenta colocar en (1,1), luego en (2,2)
	    MockMessageView messageView3 = new MockMessageView();
	    BattleshipController game3 = new BattleshipController(board3, boardView1, inputView3, messageView3, name1);

	    game3.placeShips(2);
	    assertTrue(messageView3.containsMessage("Cell already occupied. Try again.")); // Debe mostrar mensaje de error para casilla ocupada

	    // Verificar que el barco se colocó en la posición válida (2,2)
	    
	    assertEquals('S', board3.getCell(1, 1));
    } 

}


