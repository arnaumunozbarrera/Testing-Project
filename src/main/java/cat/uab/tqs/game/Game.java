package main.java.cat.uab.tqs.game;

public class Game {
	// Matrix dimensions
	public static final int DimMatrixRow = 4; 
    public static final int DimMatrixCol = 4;
    
    // Matrix of positions of the game
	
 	// W represents water
 	// S represents ship
 	// H represents ship hitted
 	
    // Board for Players to hit the ships
     public static String[][] gameP1 = {
    	 {"", "", "", ""},
	     {"", "", "", ""},
	     {"", "", "", ""},
	     {"", "", "", ""},
	     {"", "", "", ""}
     };
     
	 public static String[][] gameP2 = {
		 {"", "", "", ""},
	     {"", "", "", ""},
	     {"", "", "", ""},
	     {"", "", "", ""},
	     {"", "", "", ""}
	 };

    // Board for Players to place the ships
    public static String[][] boardP1 = {
        {"", "", "", ""},
        {"", "", "", ""},
        {"", "", "", ""},
        {"", "", "", ""},
        {"", "", "", ""}
    };
    
    public static String[][] boardP2 = {
        {"", "", "", ""},
        {"", "", "", ""},
        {"", "", "", ""},
        {"", "", "", ""},
        {"", "", "", ""}
    };
    
    public static void migotoxy(int x, int y) {
        System.out.print(String.format("\033[%d;%dH", x, y));
    }

    public static void gotoxy(int row_num, int col_num) {
        migotoxy(row_num, col_num);
    }
}
