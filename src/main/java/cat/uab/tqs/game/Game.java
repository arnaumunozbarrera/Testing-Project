package main.java.cat.uab.tqs.game;

public abstract class Game {
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
}
