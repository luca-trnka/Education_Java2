package org.example;

import java.util.Random;

public class PFArray {
    private int[] array;

    public PFArray() {
        this.array = new int[0]; //New object is initialized as empty array
    }

    public void createArrayManually(String input) {
        String[] arrayOfStringNumbers = input.split(",");  //Splits whole String into array of StringNumbers
        this.array = new int[arrayOfStringNumbers.length];

        for (int i = 0; i < arrayOfStringNumbers.length; i++) {
            try {
                this.array[i] = Integer.parseInt(arrayOfStringNumbers[i].trim());  //Remakes every StringNumber to Integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: '" + arrayOfStringNumbers[i] + "' is not a valid integer.");
                this.array = new int[0];
            }
        }

    }

    public void createRandomArray() {
        Random random = new Random();
        int max_length_size = 10;
        int max_int_size = 200;
        int length = random.nextInt(max_length_size) + 1;
        this.array = new int[length];
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = random.nextInt(max_int_size) - 100;
        }
    }

    public void arrayPrinting() {
        if (this.array.length > 0) {
            for (int i = 0; i < this.array.length; i++) {
                System.out.print(this.array[i] + " ");
            }
        }
        System.out.println("Array is empty.");
    }

    public int[] getArray() {
        return this.array;
    }


}