# Other & Interview Prep

Packages: `com.other`, `com.other.prepRapid`

Custom data structure implementations, functional programming utilities, and a series of login event analysis problems used for interview preparation.

---

## Custom Implementations

### Custom HashMap
**File:** `MyHashMap.java`

A generic `MyHashMap<K, V>` built from scratch using **separate chaining** for collision resolution:

- Internal array of `LinkedList<Entry<K,V>>` buckets
- `put(key, value)` — computes `hashCode() % capacity`, walks the chain to update or insert
- `get(key)` — same bucket lookup
- `remove(key)` — unlinks the node from the chain
- `resize()` — doubles capacity and rehashes when load factor exceeds threshold

**Time:** O(1) average, O(n) worst case per operation

---

### Functional Utilities
**File:** `MyFunctionalUtils.java`

Custom implementations of `filter()` and `map()` using Java's `Predicate<T>` and `Function<T, R>` functional interfaces:

```java
// filter: keep elements matching the predicate
public static <T> List<T> filter(List<T> list, Predicate<T> predicate)

// map: transform each element
public static <T, R> List<R> map(List<T> list, Function<T, R> mapper)
```

Demonstrates how the Streams API works under the hood.

---

## Interview Prep — Login Event Analysis

Package: `com.other.prepRapid`

A progression of three increasingly complex problems analysing user login events to detect suspicious activity.

---

### Problem 1 — Common Locations (3+ logins in one day)
**File:** `Solution.java`

Given a list of `LoginEvent(userId, location, timestamp)`, find all locations that appear **3 or more times for the same user on the same calendar day**.

**Approach:** Group by `(userId, date, location)` using a nested `HashMap`, then filter groups with count ≥ 3.

---

### Problem 2 — Enhanced Version + Sliding Window
**File:** `SolutionTwo.java`

Extends Problem 1 using a Java `Record` for cleaner event modelling:

```java
record LoginEvent(String userId, String location, LocalDateTime timestamp) {}
```

Also adds a **sliding window** variant: find locations where a user logged in **at least 2 times within any 2-hour window** — events sorted by timestamp, window shrunk from the left when the gap exceeds 2 hours.

---

### Problem 3 — Suspicious Activity Detection
**File:** `Test.java`

Two advanced detection rules:

1. **Suspicious locations** — 5 or more logins from the same location within any **30-minute window**
2. **Peak hour locations** — 10 or more logins from the same location within any **4-hour window**

Both use a sorted-by-time approach with a sliding window that evicts events older than the window duration.

---

## Summary

| File | Problem | Key Technique |
|------|---------|---------------|
| `MyHashMap` | Custom HashMap | Array + chaining |
| `MyFunctionalUtils` | filter / map | Predicate, Function |
| `Solution` | 3+ logins/day | HashMap grouping |
| `SolutionTwo` | 2 logins/2h window | Record + sliding window |
| `Test` | 5/30min, 10/4h | Sliding window |
