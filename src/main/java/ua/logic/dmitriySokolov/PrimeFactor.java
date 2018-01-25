package ua.logic.dmitriySokolov;

import java.util.ArrayList;
import java.util.List;

//    12 = 2 x 2 x 3
public class PrimeFactor {
    public static List getPrimeFactor(final int number) {
        List<Integer> result = new ArrayList<>();
        Integer oldFactor = number;
        while (oldFactor >= 2) {
            Integer factor = getFactor(oldFactor);
            if (oldFactor.equals(factor)) {
                result.add(factor);
                break;
            }
            result.add(oldFactor / factor);
            oldFactor = factor;
        }

        return result;
    }

    private static Integer getFactor(int number) {
        if (number % 11 == 0) {
            return number / 11;
        }

        if (number % 7 == 0) {
            return number / 7;
        }

        if (number % 5 == 0) {
            return number / 5;
        }

        if (number % 3 == 0) {
            return number / 3;
        }

        if (number % 2 == 0) {
            return number / 2;
        }

        return number;
    }
}
