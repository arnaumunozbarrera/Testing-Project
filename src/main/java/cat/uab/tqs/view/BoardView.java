package main.java.cat.uab.tqs.view;

import main.java.cat.uab.tqs.model.BoardModel;

public class BoardView {

	public void printBoard(BoardModel board, boolean hideShips) {
        char[][] grid = board.getGrid();
        System.out.print("  ");
        for (int i = 1; i <= grid.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int row = 0; row < grid.length; row++) {
            System.out.print(row + 1 + " ");
            for (int col = 0; col < grid[row].length; col++) { 
                char cell = grid[row][col];
                if (hideShips) {
                	if(cell == board.getShipChar()) {
                        System.out.print(board.getWater(row, col) + " ");
                	}
                	else {
                		System.out.print(board.getCell(row, col) + " ");
                	}
            	}
                else {
                    System.out.print(cell + " ");
                }
            }
            System.out.println();
        }
    }
}
