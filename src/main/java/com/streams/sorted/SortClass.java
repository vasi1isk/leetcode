package main.java.com.streams.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class SortClass {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 1, 4, 2, 3);
        List<Integer> sortedNumbersAscending = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> sortedNumbersDescending = numbers.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("ASCENDING ORDER: " + sortedNumbersAscending);
        System.out.println("DESCENDING ORDER: " + sortedNumbersDescending);

        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));

        // Сортировка по возрасту
        List<Person> sortedByNameAndAge = people.stream().sorted(Comparator.comparing(Person::getName).thenComparing(Comparator.comparing(Person::getAge)))
                .collect(Collectors.toList());

        System.out.println("SORTED BY NAME AND AGE: " + sortedByNameAndAge);
    }
}
