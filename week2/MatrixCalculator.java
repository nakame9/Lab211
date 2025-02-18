import java.util.Scanner;

public class MatrixCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMatrix Calculator:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting program...");
                break;
            }

            System.out.print("Enter number of rows: ");
            int rows = scanner.nextInt();
            System.out.print("Enter number of columns: ");
            int cols = scanner.nextInt();

            System.out.println("Enter Matrix A:");
            int[][] matrixA = inputMatrix(scanner, rows, cols);

            System.out.println("Enter Matrix B:");
            int[][] matrixB = inputMatrix(scanner, rows, cols);

            int[][] result;
            switch (choice) {
                case 1:
                    result = addMatrices(matrixA, matrixB, rows, cols);
                    System.out.println("Result of Addition:");
                    printMatrix(result);
                    break;
                case 2:
                    result = subtractMatrices(matrixA, matrixB, rows, cols);
                    System.out.println("Result of Subtraction:");
                    printMatrix(result);
                    break;
                case 3:
                    System.out.print("Enter number of columns for Matrix B: ");
                    int colsB = scanner.nextInt();
                    System.out.println("Enter Matrix B:");
                    matrixB = inputMatrix(scanner, cols, colsB);
                    result = multiplyMatrices(matrixA, matrixB, rows, cols, colsB);
                    System.out.println("Result of Multiplication:");
                    printMatrix(result);
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
        scanner.close();
    }

    private static int[][] inputMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    System.out.print("Enter value at [" + i + "][" + j + "]: ");
                    if (scanner.hasNextInt()) {
                        matrix[i][j] = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Values of matrix must be a number.");
                        scanner.next();
                    }
                }
            }
        }
        return matrix;
    }

    private static int[][] addMatrices(int[][] a, int[][] b, int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    private static int[][] subtractMatrices(int[][] a, int[][] b, int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    private static int[][] multiplyMatrices(int[][] a, int[][] b, int rows, int common, int colsB) {
        int[][] result = new int[rows][colsB];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
