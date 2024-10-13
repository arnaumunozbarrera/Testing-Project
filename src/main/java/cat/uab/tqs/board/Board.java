package main.java.cat.uab.tqs.board;
import main.java.cat.uab.tqs.game.*;


public class Board {
	

	
	public Board() {
	}
	
	public void setShip () {
		
	}
	
	public void setHit() {
		
	}
	
	public void printHit() {
		
	}
	
	public void setDeadShip() {
		
	}
	
	public void printDeadShip() {
		
	}
	
	public void printBoard(int player) {
		 
		String[][] board = (player == 1) ? Game.boardP1 : Game.boardP2;

		System.out.println("===================================");
		System.out.println("              BattleShip           ");
		System.out.println("Player " + player + ":");
		System.out.println("===================================");
		System.out.println("                                   ");
		System.out.println("     A   B   C   D           ");  

		for (int i = 0; i < Game.DimMatrixRow; i++) {
		    System.out.print("   +"); 
		    for (int j = 0; j < Game.DimMatrixCol; j++) {
		        System.out.print("---+");
		    }
		    System.out.println(); 
		    System.out.print(" " + (i + 1) + " |");

		    for (int j = 0; j < Game.DimMatrixCol; j++) {
		        String cell = board[i][j].isEmpty() ? " " : board[i][j];
		        System.out.print(" " + cell + " |");
		    }
		    System.out.println(); 
		}

		System.out.print("   +");
		for (int j = 0; j < Game.DimMatrixCol; j++) {
		    System.out.print("---+");
		}
		System.out.println(); 
	}
	
}
