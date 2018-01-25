package ua.logic.sysgears;

/*
Задание:
Задано произвольное натуральное число. Необходимо определить для него наименьшее возможное число-палиндром, которое будет больше, чем заданное.

Например, для числа 256 наименьшим палиндромом, большим, большим чем 256, является число 262

Входные данные:
Произвольное натуральное число.

Выходные данные:
Натуральное число - ближайший палиндром для заданного числа, больший по значению.
 */

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    private static Integer findPalindrome(Integer integer) {
        if (integer < 9) {
            return integer + 1;
        }

        if (integer == 9) {
            return 11;
        }

        List<Integer> integers = getListIntegers(integer);

        int indexCenter = (int)Math.ceil((double)integers.size() / 2)-1;

        if (integers.get(indexCenter) < integers.get(indexCenter+1) || isPalindrome(integer))
        {
            integers.set(indexCenter, integers.get(indexCenter) + 1);
        }

        mirrorList(integers, indexCenter);

        return getInteger(integers);
    }

    private static void mirrorList(List<Integer> integers, int indexCenter) {
        for (int i = 0; i <= indexCenter; i++) {
            integers.set(integers.size() - i - 1, integers.get(i));
        }
    }

    private static Integer getInteger(List<Integer> integers) {
        String result = "";
        for (Integer i: integers) {
            result = result + i;
        }
        return Integer.valueOf(result);
    }

    private static List<Integer> getListIntegers(Integer integer) {
        List<Integer> integers = new ArrayList<Integer>();
        String s = integer.toString();

        for(int i = 0; i<s.length();i++) {
            Integer number = Character.getNumericValue((s.charAt(i)));
            integers.add(number);
        }

        return integers;
    }

    private static boolean isPalindrome(Integer i) {
        String s = i.toString();

        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(findPalindrome(256));

//        if (findPalindrome(12345) != 12421) System.out.println(12345);
//        if (findPalindrome(123456) != 124421) System.out.println(123456);
//        if (findPalindrome(121) != 131) System.out.println(121);
//        if (findPalindrome(1221) != 1331) System.out.println(1221);
//        if (findPalindrome(1211) != 1221) System.out.println(1211);
//        if (findPalindrome(1231) != 1331) System.out.println(1231);
//        if (findPalindrome(1) != 2) System.out.println(1);
//        if (findPalindrome(9) != 11) System.out.println(9);

    }
}
