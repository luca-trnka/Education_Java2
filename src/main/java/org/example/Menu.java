package org.example;

public class Menu {

    public static String[] mainMenu = new String[]{
            "Main Menu:",
            "1. Create new array",
            "2. Your arrays",
            "3. Find array with max sum",
            "4. Find array with min sum",
            "5. Exit program"
    };

    public static String[] creationMenu = new String[]{
            "How do you want to create your new array?",
            "1. Manually",
            "2. Automatically"
    };

    public static String[] selectedArrayMenu = new String[]{
            "What do you want to do next?",
            "1. Print array",
            "2. Add number to array",
            "3. Find max number",
            "4. Find min number",
            "5. Remove number from array",
            "6. Remove all numbers from array",
            "7. Regenerate numbers in array",
            "8. Back to main menu"
    };

    public static String mainMenuToString() {
        StringBuilder sb = new StringBuilder();
        for (String t : mainMenu) {
            sb.append(t);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String selectedArrayMenuToString() {
        StringBuilder sb = new StringBuilder();
        for (String t : selectedArrayMenu) {
            sb.append(t);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String creationMenuToString() {
        StringBuilder sb = new StringBuilder();
        for (String t : creationMenu) {
            sb.append(t);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
