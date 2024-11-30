package main.java.cat.uab.tqs.view;

import java.util.Scanner;

public class InputView {
	private final Scanner scanner = new Scanner(System.in);

    public int getIntInput(String prompt) {
        int value;
        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return value;
    }
}