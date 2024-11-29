package main.java.cat.uab.tqs.model;

import java.util.Arrays;

public class BoardModel {
	private final char[][] grid;
    private char water;
    private  char ship;
    private  char hit;
    private  char miss;

    public BoardModel(int size, char water, char ship, char hit, char miss) {
    	//assert(size > 0):"The size of the board must be greater than 0" ;
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
    
    public char getWater(int row, int col) {
    	char c = '-';
        return c;
    }

    public boolean setCell(int row, int col, int size, char value) {
    	if (isBetween(row, size) && isBetween(col, size) && isValidChar(value) && size > 0) {
    		grid[row][col] = value;
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean isValidChar(char value) {
    	return value == water || value == ship || value == hit || value == miss;
    }
    
    public boolean isBetween(int coord, int size) {
    	return coord >= 0 && coord < size;
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