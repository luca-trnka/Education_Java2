package org.example;

import java.util.Arrays;
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

    public void printArray() {
        System.out.println(Arrays.toString(this.array));
    }

    public void addNumber(int number) {
        int[] newArray = new int[this.array.length + 1];
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = number;
        this.array = newArray;
        System.out.println("Number " + number + " added.");
    }

    public String findMaxNumber() {
        if (this.array.length > 0) {
            int maxNumber = this.array[0];
            for (int i = 0; i < this.array.length; i++) {
                if (this.array[i] > maxNumber) {
                    maxNumber = this.array[i];
                }
            }
            return "The largest number is: " + maxNumber + ".";
        }
        return "There are no numbers.";
    }

    public String findMinNumber() {
        if (this.array.length > 0) {
            int minNumber = this.array[0];
            for (int i = 0; i < this.array.length; i++) {
                if (this.array[i] < minNumber) {
                    minNumber = this.array[i];
                }
            }
            return "The smallest number is: " + minNumber + ".";
        } else {
            return "There are no numbers.";
        }
    }

    public void removeNumber(int number, int count, boolean onlyFirst) {

        if (count == 0) {
            System.out.println("This number is not in array.");
            return;
        }
        int lengthOfNewArray = array.length - (onlyFirst ? 1 : count);
        int[] newArray = new int[lengthOfNewArray];
        int newIndex = 0;
        int alreadyDeleted = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != number || alreadyDeleted >= count) {
                newArray[newIndex++] = array[i];
            } else {
                alreadyDeleted++;
            }
        }
        this.array = newArray;
    }

    public int findOccurencyOfNumber(int[] array, int number) {
        int count = 0;
        for (int i = 0; i < array.length; i++) { //Looking for amount of the given number in given array
            if (array[i] == number) {
                count++;
            }
        }
        return count;
    }

    public void removeAllNumbers() {
        this.array = new int[0];
    }

    public void regenerateNumbers() {
        Random random = new Random();
        int max_int_size = 200;
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = random.nextInt(max_int_size) - 100;
        }
    }

    public int sumOfElements() {
        int sum = 0;
        for (int num : this.array) {
            sum += num;
        }
        return sum;
    }


}


