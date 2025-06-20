package com.other;

import java.util.*;
import java.util.function.*;

public class MyFunctionalUtils {

    public static <T> List<T> myFilter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static <T,R> List<R> myMap(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T element : list) {
            result.add(mapper.apply(element));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Ann");

        List<String> filtered = myFilter(names, name -> name.length() > 3);
        System.out.println("Filtered names: " + filtered);

        List<Integer> nameLengths = myMap(names, String::length);
        System.out.println("Name lengths: " + nameLengths);
    }
}
