package test.java.cat.uab.tqs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardModelTest {

	private BoardModel board = new BoardModel(8, '~', 'S', 'X', '0');
	
	
	@Test
	void testBoardModel() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSize() {
		assertEquals(8,board.getSize());
	}

	@Test
	void testGetCell() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCell() {
		
		// row: vàlid i col: vàlid
		assertTrue(board.setCell(2, 2, 'S'));
		
		// row: vàlid i col: invàlid
		assertFalse(board.setCell(2, 9, 'S'));
		
		// row: invàlid i col: vàlid
		assertFalse(board.setCell(9, 2, 'S'));
		
		// row: invàlid i col: invàlid
		assertFalse(board.setCell(9, 9, 'S'));
	}
	
	@Test
	void testIsBetween() {
		//particions equivalents de row: -4,0,1,2,4,7,8,9,14
		assertFalse(board.isBetween(-4));
		assertFalse(board.isBetween(0));
		assertTrue(board.isBetween(1)); 
		assertTrue(board.isBetween(2));
		assertTrue(board.isBetween(4));
		assertTrue(board.isBetween(7));
		assertTrue(board.isBetween(8));
		assertFalse(board.isBetween(9));
		assertFalse(board.isBetween(14));
		
	}

	@Test
	void testIsCellEmpty() {
		//Celda (1,1) --> water
		assertTrue(board.isCellEmpty(1, 1));
		
		//Celda (2,2) --> ship
		board.setCell(2, 2, 'S');
		assertFalse(board.isCellEmpty(2, 2));
		
		//Celda (3,3) --> hit
		board.setCell(3, 3, 'X');
		assertFalse(board.isCellEmpty(3, 3));
		
		//Celda (4,4) --> miss
		board.setCell(4, 4, '0');
		assertFalse(board.isCellEmpty(4, 4));
	}

	@Test
	void testGetGrid() {
		fail("Not yet implemented");
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
		assertEquals('0',board.getMissChar());
	}

}
