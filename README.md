# Java Coding Practice

Just for coding practice, just for fun, and just to stay in shape.

A collection of Java implementations covering algorithms, data structures, design patterns, multithreading, functional programming, and a Spring Boot demo — organized by topic.

---

## Project Structure

```
src/main/java/com/
├── algorithms/       # Classic algorithm problems (LeetCode & custom)
├── basic/            # Foundational data structures & algorithms
├── multithreading/   # Concurrency patterns and thread safety
├── patterns/         # Creational design patterns (Singleton variants)
├── streams/          # Java Streams API & sorting
├── other/            # Functional utils, custom HashMap, interview prep
└── talks/            # Code written for technical interviews
    └── barclays/     # Spring Boot demo app (REST + JPA)
```

---

## Topics Covered

### Algorithms (`com.algorithms`)

| File | Problem / Topic |
|------|----------------|
| `LongestSubstring.java` | Longest substring without repeating characters — sliding window |
| `MaxNumberInArray.java` | Find maximum value in an array |
| `MergeIntervals.java` | Merge overlapping intervals |
| `MessageDeliveryStatus.java` | Rate-limited message delivery check using HashMap |
| `Pallindrom.java` | Count palindromic subsequences |
| `RomanNumbers.java` | Convert Roman numerals to integers |

---

### Basic Data Structures & Algorithms (`com.basic`)

| File | Topic |
|------|-------|
| `OptimalCardShuffle.java` | Fisher-Yates shuffle — O(n) deck shuffling |
| `OptimalPrimeGenerator.java` | Sieve of Eratosthenes — prime number generation |
| `OptimalRandomGenerator.java` | Fisher-Yates based random number generator without replacement |
| `Parentheses.java` | Balanced parentheses/brackets/braces validation using a generic stack |
| `RandomizedSet.java` | Data structure with O(1) insert, remove, and random-access |
| `RandomPickIndex.java` | Reservoir sampling (Knuth algorithm) — uniform random index pick |

---

### Multithreading (`com.multithreading`)

| File | Topic |
|------|-------|
| `AtomicOperations.java` | Race conditions — plain counter vs. `AtomicInteger` |
| `BankAccount.java` | Multi-threaded withdrawals demonstrating `volatile` |
| `DeadlockExample.java` | Circular lock dependency causing deadlock |
| `ProducerConsumer.java` | Classic producer-consumer with `wait`/`notify` |
| `ThreadPoolExample.java` | Fixed thread pool via `ExecutorService` |
| `VolatileExample.java` | Memory visibility with `volatile` flag |

---

### Design Patterns — Singleton (`com.patterns`)

| File | Variant |
|------|---------|
| `EagerSingleton.java` | Eager initialization — instance created at class load |
| `EnumSingleton.java` | Enum-based — preferred thread-safe approach |
| `HolderSingleton.java` | Bill Pugh / Class Holder — lazy + thread-safe |
| `LazySingleton.java` | Lazy initialization — not thread-safe |
| `LazySingletonSync.java` | Synchronized lazy — thread-safe with `synchronized` method |

---

### Java Streams & Sorting (`com.streams.sort`)

| File | Topic |
|------|-------|
| `Person.java` | POJO model for sorting examples |
| `Solution.java` | Multi-criteria sorting of integers and objects using Streams & `Comparator` |

---

### Other (`com.other`)

| File | Topic |
|------|-------|
| `MyFunctionalUtils.java` | Custom `filter()` and `map()` using `Predicate` and `Function` interfaces |
| `MyHashMap.java` | Custom `HashMap<K, V>` implementation with chaining for collision resolution |

#### Interview Prep — Login Event Analysis (`com.other.prepRapid`)

| File | Problem |
|------|---------|
| `Solution.java` | Find common locations with 3+ logins in a single calendar day |
| `SolutionTwo.java` | Enhanced version using Java `Record`; sliding window for 2 logins within 2 hours |
| `Test.java` | Suspicious location detection — 5+ logins in 30 min, peak hour (10+ in 4 hours) |

---

### Technical Talks / Interview Code (`com.talks`)

| File | Topic |
|------|-------|
| `Tricentis.java` | Read integers, compute sum/average, display in reverse order |

#### Barclays — Spring Boot Demo (`com.talks.barclays`)

A minimal Spring Boot REST + JPA application skeleton built for a technical interview.

| File | Role |
|------|------|
| `BankSpringbootApp.java` | `@SpringBootApplication` entry point |
| `BankController.java` | REST controller for bank operations |
| `Message.java` | JPA `@Entity` — message content & requester ID |
| `BankJPA.java` | `JpaRepository` interface for `Message` |
| `BankService.java` | `@Service` business logic layer |

---

## Tech Stack

- **Language:** Java 17+
- **Frameworks:** Spring Boot, Spring Data JPA
- **Concepts:** Algorithms, Data Structures, Concurrency, Design Patterns, Functional Programming, Streams
