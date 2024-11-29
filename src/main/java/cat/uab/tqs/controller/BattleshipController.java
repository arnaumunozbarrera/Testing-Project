package main.java.cat.uab.tqs.controller;

import main.java.cat.uab.tqs.model.BoardModel;
import main.java.cat.uab.tqs.view.BoardView;
import main.java.cat.uab.tqs.view.InputView;
import main.java.cat.uab.tqs.view.MessageView;

public class BattleshipController {
    private final BoardModel board;
    private final BoardView boardView;
    private final InputView inputView;
    private final MessageView messageView;
    private final String playerName;

    public BattleshipController(BoardModel board, BoardView boardView, InputView inputView, MessageView messageView, String playerName) {
        this.board = board;
        this.boardView = boardView;
        this.inputView = inputView;
        this.messageView = messageView;
        this.playerName = playerName;
    }
    
    private boolean invariant() {
		return (board.getSize() > 1);
    }

    public void placeShips(int shipCount) {
    	
    	//assert invariant(); // invariant check
    	
        messageView.showMessage(playerName + ", place your ships on the board.");
        messageView.showMessage("Ships available: " + shipCount);
        //assert (shipCount > 0): "ShipCount value must be greater than 0"; // precondition

        for (int i = 0; i < shipCount; i++) {
            while (true) {
            	
            	
                int rowPre = inputView.getIntInput(playerName + ", enter row (1-" + board.getSize() + "): ") ;
                int colPre = inputView.getIntInput(playerName + ", enter column (1-" + board.getSize() + "): ");
                
                //assert (rowPre >= 0): "Row value must be greater or equal than 0"; // precondition
                //assert (rowPre < board.getSize()): "Row value must be lower than board size"; // precondition
                //assert (colPre >= 0): "Row value must be greater or equal than 0"; // precondition
                //assert (colPre < board.getSize()): "Row value must be lower than board size"; // precondition
                
                int row = rowPre - 1;
                //assert row == rowPre - 1; // postcondition
                
                int col = colPre - 1;
                //assert col == colPre - 1; // postcondition

                System.out.println();
                
                //assert (board.getSize() > 1): "Board size value must be greater than 1"; // precondition

                if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
                    messageView.showMessage("Coordinates out of bounds. Try again.");
                } else if (!board.isCellEmpty(row, col)) {
                    messageView.showMessage("Cell already occupied. Try again.");
                } else {
                    board.setCell(row, col,board.getSize(), board.getShipChar());
                    //assert (board.getCell(row, col) != ' '): "Board cell should not be empty"; // postcondition
                    break;
                }
            }
        }
    }
    
    public int takeTurn() {
        messageView.showMessage(playerName + ", it's your turn.");
        
        //assert invariant(); // invariant check
        
        boardView.printBoard(board, true);

        while (true) {
            int rowPre = inputView.getIntInput("Enter row: ");
            int colPre = inputView.getIntInput("Enter column: ");
            
            //assert (rowPre >= 0): "Row value must be greater or equal than 0"; // precondition
            //assert (rowPre < board.getSize()): "Row value must be lower than board size"; // precondition
            //assert (colPre >= 0): "Row value must be greater or equal than 0"; // precondition
            //assert (colPre < board.getSize()): "Row value must be lower than board size"; // precondition
            
            int row = rowPre - 1;
            //assert row == rowPre - 1; // postcondition
            
            int col = colPre - 1;
            assert col == colPre - 1; // postcondition

            if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
                messageView.showMessage("Coordinates out of bounds. Try again.");
            } else {
                char target = board.getCell(row, col);
                if (target == board.getShipChar()) {
                    board.setCell(row, col, board.getSize(),board.getHitChar());
                    messageView.showMessage("Hit!");
                    //assert (board.getCell(row, col) == 'X'): "Board cell should not be hitted"; // postcondition
                    return 1; // Hit success
                } else if (target == board.getHitChar() || target == board.getMissChar()) {
                    messageView.showMessage("Already targeted. Try again.");
                    //assert (board.getCell(row, col) == 'X' || board.getCell(row, col) == 'O'): "Board cell must be already used"; // postcondition
                } else {
                    board.setCell(row, col,board.getSize(), board.getMissChar());
                    messageView.showMessage("Miss!");
                    //assert (board.getCell(row, col) == 'O'): "Board cell should be missed"; // postcondition
                    return 0; // Miss
                }
            }
        }
    }
    
}