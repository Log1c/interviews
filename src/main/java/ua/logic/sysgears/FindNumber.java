package ua.logic.sysgears;

/*
        Задание:
        Есть некий массив случайных целых чисел, в нем каждое число повторяется ровно два раза, однако, есть одно число,
        которое не имеет пары. Напишите программу для генерации файла с массивом целых чисел в YAML формате и нахождения
        числа без пары.

        Входные данные:
        Сгенерированный файл с массивом целых чисел в YAML формате.

        Выходные данные:
        Число, которое повторяется только один раз.
*/



import java.io.*;
import java.util.ArrayList;

public class FindNumber {
    private static Integer FindNumberNoPair(Integer[] array) {
        ArrayList <Integer> arrayList = new ArrayList<Integer>();
        for (Integer i:array) {
            int indexPair = arrayList.indexOf(i);
            if (indexPair == -1) {
                arrayList.add(i);
            } else {
                arrayList.remove(indexPair);
            }
        }

        if (arrayList.isEmpty()) {
            return null;
        }

        return arrayList.get(0);
    }

    private static Integer[] LoadYAML(String fileName) {
        InputStream input;

        try {
            input = new FileInputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            return new Integer[0];
        }

//        Integer[] array = (Integer[]) Yaml.load(input);
        Integer[] array = null;

        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }

    private static Integer FindNumberNoPair(String fileName) {
        Integer[] array = LoadYAML(fileName);
        return FindNumberNoPair(array);
    }

    public static void main(String[] args) {
        //Integer[] array = {1, 2, 6, 3, 6, 1, 3};

        System.out.println(FindNumberNoPair("file.txt"));
    }
}
