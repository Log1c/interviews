package ua.logic.bifit;
import java.util.Arrays;

public class Islands {

    public static int getCountIslands(int matrix[][]) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    detectIsland(matrix, i, j);
                    counter++;
                    System.out.println();
                    printArray(matrix);
                }
            }
        }
        return counter;
    }

    private static void detectIsland(int matrix[][], int i, int j) {

        if (matrix[i][j] == 0) {
            return;
        }

        matrix[i][j] = 0;

        if (i + 1 < matrix.length) {
            detectIsland(matrix, i + 1, j);
        }
        if (j + 1 < matrix[0].length) {
            detectIsland(matrix, i, j + 1);
        }
        if (i - 1 >= 0) {
            detectIsland(matrix, i - 1, j);
        }
        if (j - 1 >= 0) {
            detectIsland(matrix, i, j - 1);
        }

    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 1, 1, 0}, {1, 1, 0, 1}, {0, 0, 1, 1}, {1, 1, 1, 0}};
        printArray(matrix);
        System.out.println(getCountIslands(matrix));
    }

    private static void printArray(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}