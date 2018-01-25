package ua.logic.sysgears;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Найти наибольшую(сумма чисел) последовательность(неделимую) чисел
 */

public class MaxSum {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(-1, 2, 4, 4, -2, 5));
        //List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(-1, -2, -5));
        //List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(-1, -2, -6, -5));
        System.out.println(FindMaxSum(integerList));
    }

    private static Integer FindMaxSum(List<Integer> integerList) {
        Integer maxSum = integerList.get(0);

        for (int i = 0; i < integerList.size(); i++) {
            Integer tempSum = 0;
            for (int j = i; j < integerList.size(); j++) {
                tempSum += integerList.get(j);
                if (maxSum < tempSum) maxSum = tempSum;
            }
        }

        return maxSum;
    }
}
