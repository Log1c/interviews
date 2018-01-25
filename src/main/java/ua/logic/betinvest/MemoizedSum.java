package ua.logic.betinvest;
import java.util.ArrayList;
import java.util.List;

/*
Функция Memoize позволяет создавать функции, которые кешируют свои результаты аргументов.
        Следующие вызовы, будут смотреть сначала кеш и если рузультат на нейден, будут выполняться вычисления. и Сохранятсья кеш.

        Задача: написать функцию bounded-memoize, которая выведет кеш, последнего вычисления.
        Возвращаемая функция должна быть потокобезопасной.

        Например:
        Определить bounded-memoize
        f - запонимаемая функция
        n - число поеледних вызовов кэша

        Ограничение - 3 вызова

        (++ 1 1) ;; => 2, cache miss, save to cache
        (++ 1 2) ;; => 3, cache miss, save to cache
        (++ 1 3) ;; => 4, cache miss, save to cache

        (++ 1 1) ;; => 2, cache hit
        (++ 1 3) ;; => 4, cache hit

        (++ 1 4) ;; => 5, cache miss, save to cache
        (++ 1 1) ;; => 2, cache miss, save to cache

        - последнее вычисление не берется из кэша потому что только 3 последних результата кэшируются.
        - когда мы вычисляем (++ 1 4) мы очищаем кэш для старого вызова (++ 1 1)

        Все методы в классе java.lang.Math— это превосходные примеры чистых функций.

        HashMap исспользуется
*/

public class MemoizedSum {
    static final int MAXSIZECACHE = 3;
    private final static List<Sum> cache = new ArrayList<Sum>(MAXSIZECACHE);

    public static int sum(int arg1, int arg2) {
        Integer result;
        Sum sum = new Sum(arg1, arg2);

        synchronized (cache) {
            result = SearchInCache(sum);

            if (result != null) {
                System.out.println("cache hit");
                return result;
            }
        }

        result = sum.getResult();

        synchronized (cache) {
            System.out.println("cache miss, save to cache");
            if (cache.indexOf(sum) != -1) {
                return result;
            }

            if (cache.size() == MAXSIZECACHE) {
                cache.remove(0);
            }

            cache.add(sum);
        }

        //printCache();

        return result;
    }

//    public static void printCache() {
//        for(Sum s:cache) {
//            System.out.println(s);
//        }
//    }

    private synchronized static Integer SearchInCache(Sum sum) {
        for(Sum s:cache) {
            if (s.equals(sum)) {
                return s.getResult();
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
