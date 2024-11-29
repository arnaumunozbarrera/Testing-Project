
import main.java.cat.uab.tqs.controller.BattleshipController;
import main.java.cat.uab.tqs.model.BoardModel;
import main.java.cat.uab.tqs.view.BoardView;
import main.java.cat.uab.tqs.view.InputView;
import main.java.cat.uab.tqs.view.MessageView;

public class main {
    public static void main(String[] args) {
    	
        int boardSize = 8; // Board size 8x8 
        int shipCount = boardSize/2; // Ship number 4
        char water = '-';
        char ship = 's';
        char hit = 'X';
        char miss = 'O';

        BoardModel board1 = new BoardModel(boardSize, water, ship, hit, miss);
        BoardModel board2 = new BoardModel(boardSize, water, ship, hit, miss);
        BoardView boardView1 = new BoardView();
        BoardView boardView2 = new BoardView();
        InputView inputView1 = new InputView();
        InputView inputView2 = new InputView();
        MessageView messageView1 = new MessageView();
        MessageView messageView2 = new MessageView();
        
        BattleshipController player1Controller = new BattleshipController(board1, boardView1, inputView1, messageView1, "Player 1 (P1)");
        BattleshipController player2Controller = new BattleshipController(board2, boardView2, inputView2, messageView2, "Player 2 (P2)");
        
        // Execució Battleship amb la primera versió de codi desenvolupat
        
        player1Controller.placeShips(shipCount); 
        player2Controller.placeShips(shipCount);

        int player1Hits = 0;
        int player2Hits = 0;

        while (player1Hits < shipCount && player2Hits < shipCount) {
            player1Hits += player2Controller.takeTurn(); 
            if (player1Hits == shipCount) break;

            player2Hits += player1Controller.takeTurn(); 
        }

        if (player1Hits == shipCount) {
        	System.out.println();
            System.out.println("Player 1 (P1) wins!");
            System.out.println("P2 ships still alive");
            for (int i = 1; i <= shipCount - player2Hits; i++) {
            	System.out.println("Ship "+ i + " still alive");
            }

        } else {
        	System.out.println();
            System.out.println("Player 2 (P2) wins!");
            System.out.println("P2 ships still alive");
            for (int i = 1; i <= shipCount - player2Hits ; i++) {
            	System.out.println("Ship "+ i + " still alive");
            }
        }     
        
        // Execució Battleship amb la segon versió de codi desenvolupat
        /*
        player1Controller.placeShips(shipCount); 
        player2Controller.placeShips(shipCount);

        int player1Hits2 = 0;
        int player2Hits2 = 0;

        while (player1Hits2 < shipCount && player2Hits2 < shipCount) {
            player1Hits2 += player2Controller.takeTurn2(); 
            if (player1Hits2 == shipCount) break;

            player2Hits2 += player1Controller.takeTurn2(); 
        }

        if (player1Hits2 == shipCount) {
        	System.out.println();
            System.out.println("Player 1 (P1) wins!");
        } else {
        	System.out.println();
            System.out.println("Player 2 (P2) wins!");
        }
		*/
    }
}
