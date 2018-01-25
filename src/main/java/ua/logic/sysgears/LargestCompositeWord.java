package ua.logic.sysgears;
/*
Задание:
Задан отсортированный в алфавитном порядке массив слов, состоящий из символов латинского алфавита в нижнем регистре (a-z).
 Необходимо определить наибольшее по длине составное слово в массиве. Под "составным" подразумевается слово,
 полностью сконструированное из других слов данного массива при помощи конкатенации.

К примеру, для массива ['five', 'fivetwo', 'fourfive', 'fourfivetwo', 'one', "onefiveone", "two", "twofivefourone"]
Ответом будет слово 'fourfivetwo' с 11 буквами.

Входные данные:
ОТсортированный в алфавитном порядке массив слов, состоящий из символов латинского алфавита в нижнем регистре (a-z).

Выходные данные:
Наибольшее по длине составное слово.
 */

import java.util.*;

class SortedByLength implements Comparator <String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }
}

public class LargestCompositeWord {
    public static void main(String[] args) {
        String[] strings = {"five", "fivetwo", "fourfive", "fourfivetwo", "one", "onefiveone", "two", "twofivefourone"};

        String s = findLargestCompositeWord(strings);
        System.out.println(s);
    }

    private static String findLargestCompositeWord(String[] strings) {
        List <String> wordsSortedByLength = new ArrayList<String>();

        Collections.addAll(wordsSortedByLength, strings);
        Collections.sort(wordsSortedByLength, new SortedByLength());
        Collections.reverse(wordsSortedByLength);

        String word;
        for (int i = 0; i<wordsSortedByLength.size(); i++) {
            word = wordsSortedByLength.get(i);
            if (isCompositeWord(word, wordsSortedByLength, i+1)) {
                return word;
            }
        }

        return null;
    }

    private static boolean isCompositeWord(String word, final List<String> wordsSortedByLength, int startIndex) {
        //startIndex - need, don't to find himself
        List<String> wordsSortedByLengthExceptFounds = new ArrayList<String>(wordsSortedByLength);
        boolean searching = true;
        while (searching) { //repeat the search if the entry found
            searching = false;
            for(int i = startIndex; i < wordsSortedByLengthExceptFounds.size(); i++) {
                String examineWord = wordsSortedByLengthExceptFounds.get(i);
                if (word.contains(examineWord)) {
                    word = word.replaceFirst(examineWord, "");
                    wordsSortedByLengthExceptFounds.remove(i);//delete words to avoid re-use
                    searching = true;
                    break;
                }
            }
        }
        return word.isEmpty();
    }
}
