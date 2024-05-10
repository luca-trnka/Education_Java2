package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<PFArray> arrays = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            mainMenu();
            int option = readIntFromUser("Choose an option: ");

            switch (option) {
                case 1:
                    createNewArray();
                    break;
                case 2:
                    //yourArrays();
                    break;
                case 3:
                    //findArrayWithMaxSum();
                    break;
                case 4:
                    //findArrayWithMinSum();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting program. Bye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void mainMenu() {
        System.out.println(Menu.mainMenuToString());
    }

    private static void createNewArray() {

        while (true) {
            System.out.println(Menu.creationMenuToString());
            int option = readIntFromUser("Choose an option: ");
            PFArray newArray;
            switch (option) {
                case 1:
                    while (true) {
                        System.out.println("Enter numbers separated by commas (f.e. \"1,2,3\"): ");
                        String input = scanner.nextLine();
                        newArray = new PFArray();
                        newArray.createArrayManually(input);
                        if (newArray.getArray().length > 0) {
                            System.out.println("Array created manually.");
                            arrays.add(newArray);
                            return;
                        } else {
                            System.out.println("Try it again;)!");
                        }
                    }
                case 2:
                    newArray = new PFArray();
                    newArray.createRandomArray();
                    System.out.println("Random array created.");
                    arrays.add(newArray);
                    return;

                default:
                    System.out.println("Invalid option, please enter 1 or 2.");
                    break;
            }
        }
    }

    private static int readIntFromUser(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
            }
        }
    }
}

