import java.util.Scanner;

public class main {

    // Método para imprimir el menú
    public static void printMenu() {

        System.out.println("_______________________________________________________________________________");
        System.out.println("|                                                                             |");
        System.out.println("|                               MENU BATTLESHIP                               |");
        System.out.println("|_____________________________________________________________________________|");
        System.out.println("|                                                                             |");
        System.out.println("|                               1. Place ships for P1                         |");
        System.out.println("|                               2. Place ships for P2                         |");
        System.out.println("|                               3. Play                    		      |");
        System.out.println("|                               4. Reset Boards                               |");
        System.out.println("|                                                                             |");
        System.out.println("|                               0. Exit                                       |");
        System.out.println("|                                                                             |");
        System.out.println("|_____________________________________________________________________________|");
        System.out.println("|                                                                             |");
        System.out.println("|                               OPTION:                                       |");
        System.out.println("|_____________________________________________________________________________|");
        System.out.println("                                                                               ");

    }

    public static void main(String[] args) {
        // Print Menu
        printMenu();

        // Read option
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your option: ");
        int option = scanner.nextInt();

        // Aquí se puede agregar la lógica de procesamiento según la opción seleccionada
        System.out.println("\nYou selected option: " + option);
    }
}
