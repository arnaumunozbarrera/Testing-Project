package test.java.cat.uab.tqs.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.cat.uab.tqs.board.Board;

class BoardTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void setShipTest () {
		Board board = new Board();
		board.setShip();
		assertEquals(board.getShip(), 0);
	}
	
	@Test
	void setHitTest() {
		Board board = new Board();
		board.printBoard(1);
		board.setHit();
		board.printHit();
		
		board.printBoard(2);
	}
	
	@Test
	void setDeadShipTest() {
		Board board = new Board();
		board.setDeadShip();
		assertEquals(board.getDeadShip(), 0);
		
	}

}
