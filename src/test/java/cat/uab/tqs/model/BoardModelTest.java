package test.java.cat.uab.tqs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.cat.uab.tqs.model.BoardModel;

class BoardModelTest {
	
	private BoardModel board = new BoardModel(4, '-', 'S', 'X', 'O');

	@Test
	void testSetCell() {
		//cas 1: row vàlid, col vàlid, size vàlid, value vàlid
		assertTrue(board.setCell(2, 2,board.getSize(), 'S'));
		
		//cas 2: row vàlid, col vàlid, size vàlid, value invàlid
		assertFalse(board.setCell(2, 2,board.getSize(), '?'));
		
		//cas 3: row vàlid, col vàlid, size invàlid, value vàlid
		assertFalse(board.setCell(2, 2,-1, 'S'));
		
		//cas 4: row vàlid, col invàlid, size vàlid, value vàlid
		assertFalse(board.setCell(2, 9,board.getSize(), 'X'));
		
		//cas 5: row vàlid, col invàlid, size vàlid, value invàlid
		assertFalse(board.setCell(2, 9,board.getSize(), '?'));
		
		//cas 6: row invàlid, col vàlid, size vàlid, value vàlid
		assertFalse(board.setCell(9, 2,board.getSize(), 'O'));
		
		//cas 7: row invàlid, col vàlid, size vàlid, value invàlid
		assertFalse(board.setCell(9, 2,board.getSize(), '?'));
		
		//cas 8: row invàlid, col invàlid, size invàlid, value vàlid
		assertFalse(board.setCell(9, 9,-1, '-'));
		
		//cas 9: row invàlid, col invàlid, size invàlid, value invàlid
		assertFalse(board.setCell(9, 9,-1, '?'));
	}
	
	@Test
	void testIsValidChar() {
		//Hacer Condition coverage y state coverage 
		assertTrue(board.isValidChar('-'));
		assertTrue(board.isValidChar('S'));
		assertTrue(board.isValidChar('X'));
		assertTrue(board.isValidChar('O'));
		assertFalse(board.isValidChar('?'));
		assertFalse(board.isValidChar('a'));
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