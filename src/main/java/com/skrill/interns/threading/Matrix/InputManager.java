package com.skrill.interns.threading.Matrix;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputManager {
    Scanner input = new Scanner(System.in);
    private final String PATTERN = "^-?[0-9]+([.][-0-9])?+$";
    MatrixManipulator manipulator;
    Matrix multiplicationResult;
    BigDecimal[] sumResult;



    private BigDecimal getNumberFromUser() {
        String line = input.nextLine();
        while (line.matches(PATTERN) == false) {
            System.out.println("That was not a number! Try again: ");
            line = input.nextLine();
        }
        return new BigDecimal(line);
    }

    private BigDecimal[][] getInputFromUser(int size)
    {
        BigDecimal[][] matrix = new BigDecimal[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // System.out.format("Enter element [%s][%s]", i, j);
                // BigDecimal number = this.getNumberFromUser();
                matrix[i][j] = BigDecimal.ONE;
            }
        }
        return matrix;
    }

    private void printBigDecimalArray(BigDecimal a[]) {
        StringBuilder array = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            array.append(a[i] + " ");
        }
        System.out.println(array.toString());
    }

    public void enterTwoMatrices() {
        this.manipulator = new MatrixManipulator();
        System.out.println("Enter the size of the matrix : ");
        int size = 0;
        do {
            System.out.println("That was not a valid number! Try again: ");
            size = this.getNumberFromUser().intValue();
        } while (size < 0);
        System.out.println("Enter the first matrix : ");
        BigDecimal[][] matrix1 = this.getInputFromUser(size);
        System.out.println("Enter the second matrix : ");
        BigDecimal[][] matrix2 = this.getInputFromUser(size);
        System.out.println("\nMultiplication result:");
        this.multiplicationResult = this.manipulator.multiply(matrix1, matrix2);
        System.out.print(this.multiplicationResult.toString());
        // this.sumResult = this.manipulator.sum(this.multiplicationResult);
        // System.out.println("Sum: ");
        // printBigDecimalArray(this.sumResult);
        System.out.println();
    }

    // public void useOldInput() {
    // if (this.matrix1 != null && this.matrix2 != null) {
    // System.out.println("\nMultiplication result:");
    // this.multiplicationResult = this.manipulator.multiply(this.matrix1, this.matrix2);
    // System.out.print(this.multiplicationResult.toString());
    // this.sumResult = this.manipulator.sum(this.multiplicationResult);
    // System.out.println("Sum: ");
    // printBigDecimalArray(this.sumResult);
    // System.out.println();
    // } else {
    // System.out.println("There are no previuos matrixes!");
    // }
    // }
    public void menu() {
        int choice = 0;
        do {
            System.out.println("MENU");
            System.out.println("1.Enter new matrices ");
            System.out.println("2.Use previous matrices ");
            System.out.println("3.Exit");
            choice = this.getNumberFromUser().intValue();
            switch (choice) {
            case 1:
                enterTwoMatrices();
                break;
            case 2:
                // useOldInput();
                break;
            case 3:
                MatrixManipulator.shutdownThreadPool();
                return;
            default:
                System.out.println("No such option!");
            }
        } while (choice != 3);
    }
}
