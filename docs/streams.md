# Java Streams & Sorting

Package: `com.streams.sort`

Demonstrates the Java Streams API for sorting collections using `Comparator` chaining.

---

## Files

### Person Model
**File:** `Person.java`

Simple POJO with two fields used as a sorting subject:

```java
public class Person {
    private String name;
    private int age;
    // constructor, getters
}
```

---

### Sorting Solution
**File:** `Solution.java`

Covers several sorting scenarios using `Stream.sorted()` and `Comparator`:

#### Sort integers in reverse order
```java
List<Integer> sorted = numbers.stream()
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.toList());
```

#### Sort persons by name, then by age ascending
```java
List<Person> sorted = persons.stream()
    .sorted(Comparator.comparing(Person::getName)
                      .thenComparingInt(Person::getAge))
    .collect(Collectors.toList());
```

#### Sort persons by age descending, then name alphabetically
```java
List<Person> sorted = persons.stream()
    .sorted(Comparator.comparingInt(Person::getAge).reversed()
                      .thenComparing(Person::getName))
    .collect(Collectors.toList());
```

---

## Key Comparator Methods

| Method | Description |
|--------|-------------|
| `Comparator.comparing(keyExtractor)` | Sort by a field naturally |
| `Comparator.comparingInt(keyExtractor)` | Optimised for int fields |
| `.reversed()` | Reverses the comparator order |
| `.thenComparing(...)` | Secondary sort key |
| `Comparator.reverseOrder()` | Natural order reversed |
| `Comparator.naturalOrder()` | Default natural order |
