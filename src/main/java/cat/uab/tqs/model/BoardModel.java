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
	void testSetCellCondition() {
		
		// Condition 1 row, false
		
		assertFalse(board.setCell(15, 2,board.getSize(), 'S'));
		
		// Condition 2 row, true
		
		assertTrue(board.setCell(2, 2,board.getSize(), 'S'));
		
		// Condition 1 col, false
		
		assertFalse(board.setCell(2, 15,board.getSize(), 'S'));
		
		// Condition 2 col, true
		
		assertTrue(board.setCell(2, 2,board.getSize(), 'S'));

		// Condition 1 size, false
		
		assertFalse(board.setCell(2, 2, -1, 'S'));

		// Condition 2 size, true
		
		assertTrue(board.setCell(2, 2, 4, 'S'));

		
		// Condition 1 value, false
		
		assertFalse(board.setCell(2, 2,board.getSize(), '?'));

		// Condition 2 value, true
		
		assertTrue(board.setCell(2, 2,board.getSize(), 'S'));
	}
	
	@Test
	void testSetCellDecision() {
		
		// Decision 1, false
		
		assertFalse(board.setCell(2, 2,board.getSize(), '?'));
		
		// Decision 1, true
		
		assertTrue(board.setCell(2, 2,board.getSize(), 'S'));
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
	void testIsValidCharDecision() {
		
		// Decision 1, false 

		assertFalse(board.isValidChar('?'));
		
		// Decision 1, true 
		
		assertTrue(board.isValidChar('S'));
	}
	
	@Test
	void testIsBetweenParticionsEquivalentsAndValorsLimitAndFrontera() {
		
		// En aquest test considerem una matriu 4x4, on els valors a provar són:
		// Particions equivalents: vàlid (2), no vàlid (-8,8)
		// Valors límit: 0 i 3
		// Valors frontera: dins dels límits (0 i 3) i fora (-1 i 4)
		
		assertFalse(board.isBetween(-8,board.getSize()));
		assertFalse(board.isBetween(-1,board.getSize()));
		assertTrue(board.isBetween(0,board.getSize()));
		assertTrue(board.isBetween(1,board.getSize()));
		assertTrue(board.isBetween(2,board.getSize()));
		assertTrue(board.isBetween(3,board.getSize()));
		assertFalse(board.isBetween(4,board.getSize()));
		assertFalse(board.isBetween(8,board.getSize()));
	}
	
	@Test
	void testIsBetweenCondition() {
		
		// Condition 1 coord => 0, false 

		assertFalse(board.isBetween(-1,board.getSize()));
		
		// Condition 2 coord => 0, true 
		
		assertTrue(board.isBetween(2,board.getSize()));
		
		// Condition 1 coord < size, false 

		assertFalse(board.isBetween(8,board.getSize()));
		
		// Condition 2 coord <size , true 
		
		assertTrue(board.isBetween(2,board.getSize()));
	}
	
	@Test
	void testIsBetweenDecision() {
	
		// Decision 1, false 

		assertFalse(board.isBetween(-1,board.getSize()));
		
		// Decision 1, true 
		
		assertTrue(board.isBetween(2,board.getSize()));
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