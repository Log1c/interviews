package ua.logic.bifit;

import java.util.Arrays;

public class Searcher {
    public static int findElementInSortedMatrix(int needed, int[][] matrix){
        System.out.println("needed = "+ needed);
        int i = 0;
        int j = matrix[0].length - 1;
        int counter = 0;

        while (true) {
            //System.out.println("i=" + i + ", j=" + j);
            counter++;
            if ((i > matrix.length - 1) || (j < 0)) {
                System.out.println("НЕТ");
                break;
            } else if (needed == matrix[i][j]) {
                System.out.println("ДА " + "[" + i + "]" + "" + "[" + j + "]");
                break;
            } else if (needed > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }

        return counter;
    }

    private static void printArray(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }

    public static void main(String[] args) {
        final int[][] matrix = {{1,2,5},{3,4,6},{7,8,9},{12,13,14}};
        printArray(matrix);
        int limit = matrix.length + matrix[0].length;
        int counter = findElementInSortedMatrix(1, matrix);
        //System.out.println("" + counter + "/" + limit);
    }
}