package test.java.cat.uab.tqs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.cat.uab.tqs.model.BoardModel;

class BoardModelTest {
	
	private BoardModel board = new BoardModel(4, '-', 'S', 'X', 'O');

	@Test
	void testSetCell() {
		
		// row: vàlid i col: vàlid
		assertTrue(board.setCell(2, 2,board.getSize(), 'S'));
		
		// row: vàlid i col: invàlid
		assertFalse(board.setCell(2, 9,board.getSize(), 'S'));
		
		// row: invàlid i col: vàlid
		assertFalse(board.setCell(9, 2,board.getSize(), 'S'));
		
		// row: invàlid i col: invàlid
		assertFalse(board.setCell(9, 9,board.getSize(), 'S'));
	}
	
	@Test
	void testIsBetween() {
		//Teniendo en cuenta una matriz de 4x4, particions equivalents de row: -4,0,1,2,3,4,5,8
		assertFalse(board.isBetween(-4,board.getSize()));
		assertFalse(board.isBetween(-1,board.getSize()));
		assertTrue(board.isBetween(0, board.getSize())); 
		assertTrue(board.isBetween(1, board.getSize()));
		assertTrue(board.isBetween(2, board.getSize()));
		assertTrue(board.isBetween(3, board.getSize()));
		assertFalse(board.isBetween(4, board.getSize()));
		assertFalse(board.isBetween(5, board.getSize()));
		assertFalse(board.isBetween(8, board.getSize()));

	}

	@Test
	void testIsCellEmpty() {
		//Celda (1,1) --> water
		assertTrue(board.isCellEmpty(1, 1));
		
		//Celda (2,2) --> ship
		board.setCell(2, 2, board.getSize(), 'S');
		assertFalse(board.isCellEmpty(2, 2));
		
		//Celda (3,3) --> hit
		board.setCell(3, 3,board.getSize(), 'X');
		assertFalse(board.isCellEmpty(3, 3));
		
		//Celda (4,4) --> miss
		board.setCell(3, 3,board.getSize(), 'O');
		assertFalse(board.isCellEmpty(3, 3));
	}


	@Test
	void testGetShipChar() {
		assertEquals('S',board.getShipChar());
	}

	@Test
	void testGetHitChar() {
		assertEquals('X',board.getHitChar());
	}

	@Test
	void testGetMissChar() {
		assertEquals('O',board.getMissChar());
	}

}
