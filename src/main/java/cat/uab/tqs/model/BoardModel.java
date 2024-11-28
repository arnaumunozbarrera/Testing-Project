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
    
    private boolean invariant () {
    	return (grid.length > 1);
    }

    public int getSize() {
    	
    	assert invariant (); // invariant check
    	
        return grid.length;
    }

    public char getCell(int row, int col) {
    	
    	assert (row >= 0): "Row value too low"; // precondition
    	assert (col >= 0): "Row value too low"; // precondition
    	
        return grid[row][col];
    }
    
    public char getWater(int row, int col) {
    	char c = '-';
        return c;
    }

    public boolean setCell(int row, int col, int size, char value) {
    	
    	assert invariant(); // invariant check
    	
    	if (isBetween(row, size) && isBetween(col, size)) {
    		grid[row][col] = value;
    		return true;
    	} else {
    		return false;
    	}
    }

    public boolean isBetween(int coord, int size) {
    	assert (size > 0): "Size value too low"; // precondition
    	assert (coord >= 0): "Coord value too low"; // precondition
    	assert (coord < 5): "Coord value too high"; // precondition
    	return coord >= 0 && coord < size;
    }

	public boolean isCellEmpty(int row, int col) {
		assert (row >= 0): "Row value too low"; // precondition
    	assert (row < 5): "Row size too high"; // precondition
    	assert (col >= 0): "Row value too low"; // precondition
    	assert (col < 5): "Row value too high"; // precondition
        return grid[row][col] == water;
    }

    public char[][] getGrid() {
    	assert (grid.length > 1): "Grid length too small"; // precondition
    	assert (grid.length < 5): "Grid length too high"; // precondition
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
