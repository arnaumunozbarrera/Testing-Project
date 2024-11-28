package main.java.cat.uab.tqs.model;

import java.util.Arrays;

public class BoardModel {
	private final char[][] grid;
    private char water;
    private  char ship;
    private  char hit;
    private  char miss;

    public BoardModel(int size, char water, char ship, char hit, char miss) {
        this.grid = new char[size][size];
        this.water = water;
        this.ship = ship;
        this.hit = hit;
        this.miss = miss;
        for (char[] row : grid) {
            Arrays.fill(row, water);
        }
    }

    public int getSize() {
        return grid.length;
    }

    public char getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean setCell(int row, int col, char value) {
    	if (isBetween(row) && isBetween(col)) {
    		grid[row][col] = value;
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean isBetween(int coord) {
    	return coord >= 1 && coord <= 8;
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col] == water;
    }

    public char[][] getGrid() {
        return grid;
    }

    public char getShipChar() {
        return ship;
    }

    public char getHitChar() {
        return hit;
    }

    public char getMissChar() {
        return miss;
    }
}

