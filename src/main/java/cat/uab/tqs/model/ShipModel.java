package main.java.cat.uab.tqs.model;

public class ShipModel {
	private int row;
    private int col;
    
    private boolean invariant() {
    	return (row >= 0 && col >= 0);
    }

    public ShipModel(int row, int col) {
    	
    	//assert invariant(); // invariant check
    	
        this.row = row;
        this.col = col;
    }

    public int getRow() {
    	
    	//assert (row => 0): "Row value too low"; 
    	
        return row;
    }

    public int getCol() {
    	
    	//assert (col => 0): "Col value too low"; 

        return col;
    }
}
