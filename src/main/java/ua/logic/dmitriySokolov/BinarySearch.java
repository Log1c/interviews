package ua.logic.dmitriySokolov;

public class BinarySearch {
    final static int NOT_FOUND = -1;

    public static int search(final int[] where, final int find) {
        int startSearch = 0;
        int endSearch = where.length - 1;
        int currentValueInPlace;
        while (true) {
            int place = (startSearch + endSearch) / 2;
            currentValueInPlace = where[place];

            if (currentValueInPlace == find) {
                return place;
            }

            if (endSearch <= 0 || startSearch >= endSearch) {
                return NOT_FOUND;
            }

            if (currentValueInPlace < find) {
                startSearch = ++place;
            } else if (currentValueInPlace > find) {
                endSearch = --place;
            }
        }
    }
}
