package test.java.cat.uab.tqs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.cat.uab.tqs.model.BoardModel;

class BoardModelTest {
	
	private BoardModel board = new BoardModel(4, '-', 'S', 'X', 'O');

	@Test
	void testSetCellPairwise() {
		
		// 1. row vàlid, col vàlid, size vàlid, value vàlid
		
		assertTrue(board.setCell(2, 2,board.getSize(), 'S'));
		
		// 2. row vàlid, col vàlid, size vàlid, value invàlid
		
		assertFalse(board.setCell(2, 2,board.getSize(), '?'));
		
		// 3. row vàlid, col vàlid, size invàlid, value vàlid
		
		assertFalse(board.setCell(2, 2,-1, 'S'));
		
		// 4. row vàlid, col invàlid, size vàlid, value vàlid
		
		assertFalse(board.setCell(2, 9,board.getSize(), 'X'));
		
		// 5. row vàlid, col invàlid, size vàlid, value invàlid
		
		assertFalse(board.setCell(2, 9,board.getSize(), '?'));
		
		// 6. row invàlid, col vàlid, size vàlid, value vàlid
		
		assertFalse(board.setCell(9, 2,board.getSize(), 'O'));
		
		// 7. row invàlid, col vàlid, size vàlid, value invàlid
		
		assertFalse(board.setCell(9, 2,board.getSize(), '?'));
		
		// 8. row invàlid, col invàlid, size invàlid, value vàlid
		
		assertFalse(board.setCell(9, 9,-1, '-'));
		
		// 9. row invàlid, col invàlid, size invàlid, value invàlid
		
		assertFalse(board.setCell(9, 9,-1, '?'));
	}
	
	@Test
	void testIsValidCharStatementAndCondition() {
		
		// Statement & Condition coverage
		
		assertTrue(board.isValidChar('-'));
		assertTrue(board.isValidChar('S'));
		assertTrue(board.isValidChar('X'));
		assertTrue(board.isValidChar('O'));
		assertFalse(board.isValidChar('?'));
		assertFalse(board.isValidChar('a'));
	}
	
	@Test
	void testIsBetweenParticionsEquivalentsAndValorsLimitAndFrontera() {
		
		// En aquest test considerem una matriu 4x4, on els valors a provar són:
		// Particions equivalents: vàlid (2), no vàlid (-1)
		// Valors límit: 0 i 3
		// Valors frontera: dins dels límits (0 i 3) i fora (-1 i 4)
		
		assertTrue(board.isBetween(2,board.getSize()));
		assertFalse(board.isBetween(-1,board.getSize()));
		assertTrue(board.isBetween(0,board.getSize()));
		assertTrue(board.isBetween(3,board.getSize()));
		
		assertFalse(board.isBetween(4,board.getSize()));
	}

	@Test
	void testIsCellEmpty() {
		
		// Casella (1,1) --> Water
		
		assertTrue(board.isCellEmpty(1, 1));
		
		// Casella (2,2) --> Ship
		
		board.setCell(2, 2, board.getSize(), 'S');
		assertFalse(board.isCellEmpty(2, 2));
		
		// Casella (3,3) --> Hit
		
		board.setCell(3, 3,board.getSize(), 'X');
		assertFalse(board.isCellEmpty(3, 3));
		
		// Casella (4,4) --> Miss
		
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