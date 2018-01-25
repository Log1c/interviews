package ua.logic.pfsoft;
/*
Имеется текстовый файл, в котором записаны формулы, одна строка — одна формула.
Необходимо прочитать формулы из файла и проверить правильная ли формула.
Формула считаеться неправильной если в ней имеются открываюшие скобки, для которых нет закрывающих или наоборот, есть закрывающие, для которых нет открывающих.
Все неправильные формулы записать в другой файл и строчкой ниже символом ^ указать позиции неправильных скобок, для которых нет пары.
Пример файла:
in.txt
(a+b) — (a-b)
a*(a+b
d — 5*(s/((s+5) +5)+(5+f

результат работы:
out.txt
a*(a+b
^
d — 5*(s/((s+5) +5)+(5+f
^          ^

Программа запускаеться из консоли, в качестве параметров программе передаються пути к файлу с формулами и путь к файлу, в который следует записать результат.
*/
import java.io.*;

public class Parentheses {
    static void SaveWrongParentheses(String pathIn, String pathIOut) throws IOException {
        File file = new File(pathIn);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream( file ), "Cp1251"
                )
        );

        BufferedWriter bw = new BufferedWriter(
                new FileWriter(pathIOut, false)
        );

        String formula;
        while ((formula = br.readLine()) != null) {
            String wrongParentheses = getWrongParentheses(formula);
            if (!wrongParentheses.trim().isEmpty()) {
                bw.write(formula);
                bw.write("\r\n");
                bw.write(wrongParentheses);
                bw.write("\r\n");
            }
        }

        br.close();
        bw.close();
    }

    static int getCountIncorrectParentheses(String s) {
        int countOpenHooks = s.length() - s.replaceAll("\\(", "").length();
        int countCloseHooks = s.length() - s.replaceAll("\\)", "").length();

        return countOpenHooks - countCloseHooks;
    }

    static String getWrongParentheses(String s) {

        int startPositionSearching = 0;
        int endPositionSearching = s.length();
        int startPositionOpenHook = s.indexOf("(");
        int endPositionCloseHook = s.lastIndexOf(")");
        int correction = 0;
        if (s.indexOf(")") < startPositionOpenHook) {
            startPositionSearching = startPositionOpenHook;
        }
        if (s.lastIndexOf("(") > endPositionCloseHook) {
            endPositionSearching = endPositionCloseHook;
            correction = 1;
        }

        String searchString;
        if (startPositionSearching < endPositionSearching) {
            searchString = s.substring(startPositionSearching, endPositionSearching + correction);
        } else {
            searchString = "";
        }

        int countIncorrectHooks = getCountIncorrectParentheses(searchString);
        StringBuilder result = new StringBuilder(s.length());
        result.setLength(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                if (i > endPositionSearching) {
                    result.replace(i, i+1, "^");
                } else if (countIncorrectHooks > 0) {
                    result.replace(i, i+1, "^");
                    countIncorrectHooks--;
                }
            } else if (c== ')') {
                if (i < startPositionSearching) {
                    result.replace(i, i+1, "^");
                } else if (countIncorrectHooks < 0) {
                    result.replace(i, i+1, "^");
                    countIncorrectHooks++;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        SaveWrongParentheses("D:\\in.txt", "D:\\out.txt");
    }
}
