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
	void testBattleshipController() {
		fail("Not yet implemented");
	}

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
	void testStartGame() {
		fail("Not yet implemented");
	}

}
