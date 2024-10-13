import java.util.Scanner;

import main.java.cat.uab.tqs.board.Board;

import java.io.IOException;


public class main {

	 public static void clearTerminal() {
		 for(int i=0;i < 100; i++)
			 System.out.println("\n                                                                               \n");
	 }
	
    // Method to print menu
    public static void printMenu() {

        System.out.println("\t\t\t_______________________________________________________________________________");
        System.out.println("\t\t\t|                                                                             |");
        System.out.println("\t\t\t|                               MENU BATTLESHIP                               |");
        System.out.println("\t\t\t|_____________________________________________________________________________|");
        System.out.println("\t\t\t|                                                                             |");
        System.out.println("\t\t\t|                               1. Place ships for P1                         |");
        System.out.println("\t\t\t|                               2. Place ships for P2                         |");
        System.out.println("\t\t\t|                               3. Play                    		      |");
        System.out.println("\t\t\t|                               4. Reset Boards                               |");
        System.out.println("\t\t\t|                                                                             |");
        System.out.println("\t\t\t|                               0. Exit                                       |");
        System.out.println("\t\t\t|                                                                             |");
        System.out.println("\t\t\t|_____________________________________________________________________________|");
        System.out.println("\t\t\t|                                                                             |");
        System.out.println("\t\t\t|                               OPTION:                                       |");
        System.out.println("\t\t\t|_____________________________________________________________________________|");
        System.out.println("\t\t\t                                                                               ");

    }

    public static void main(String[] args) {
        // Print Menu
        printMenu();

        // Read option
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your option: ");
        int option = scanner.nextInt();
        
        
        while (option > 4 || option < 0)
        {
        

            switch (option) {
            	case 0:
            		//clearTerminal();
            		System.exit(0);
            		System.out.println("Exit game successfully");
            		break;
            		
            	case 1:
            		break;
            		
            	case 2:
            		break;
            		
            	case 3:
            		break;
            		
            	case 4:
            		break;
            		
            	default:
            		System.out.println("Option is not correct");
            		scanner = new Scanner(System.in);
                    System.out.print("\nEnter your option again: ");
                    option = scanner.nextInt();
            		break;
            		
            }
        }
    }
}
