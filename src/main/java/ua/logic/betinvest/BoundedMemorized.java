package ua.logic.betinvest;

import java.util.Map;

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
public class BoundedMemorized {
    private final int MAX_SIZE_CACHE;
    private final Map<Sum, Double> cache;

    public BoundedMemorized(int max_size_cache) {
        cache = new SimpleLRUCache<>(MAX_SIZE_CACHE = max_size_cache);
    }

    public Map<Sum, Double> getCache() {
        return cache;
    }

    public synchronized Double sum(int a, int b) {
        Sum sum = new Sum(a, b);
        Double result = cache.computeIfAbsent(sum, a1 -> {
            System.out.println("cache miss, save to cache");

            return sum.getResult();
        });

        return result;
    }


}
