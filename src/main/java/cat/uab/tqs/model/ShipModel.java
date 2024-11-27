package main.java.cat.uab.tqs.model;

public class ShipModel {
	private int row;
    private int col;

    public ShipModel(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
