# Design Patterns — Singleton

Package: `com.patterns`

Five different implementations of the **Singleton** creational pattern in Java, ranging from the simplest to the most robust.

---

## Variants

### 1. Eager Initialization
**File:** `EagerSingleton.java`

The instance is created **at class loading time** by the JVM — before any client code can call `getInstance()`.

```java
public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();
    private EagerSingleton() {}
    public static EagerSingleton getInstance() { return INSTANCE; }
}
```

**Pros:** Simple, thread-safe (JVM class loading is synchronized)  
**Cons:** Instance created even if never used (wasteful for expensive objects)

---

### 2. Lazy Initialization (not thread-safe)
**File:** `LazySingleton.java`

Creates the instance only when first requested.

```java
public class LazySingleton {
    private static LazySingleton instance;
    public static LazySingleton getInstance() {
        if (instance == null) instance = new LazySingleton();
        return instance;
    }
}
```

**Pros:** Lazy — only created when needed  
**Cons:** NOT thread-safe — two threads can create two instances simultaneously

---

### 3. Synchronized Lazy Initialization
**File:** `LazySingletonSync.java`

Adds a `synchronized` keyword to `getInstance()` to fix the race condition.

```java
public static synchronized LazySingletonSync getInstance() {
    if (instance == null) instance = new LazySingletonSync();
    return instance;
}
```

**Pros:** Thread-safe  
**Cons:** Synchronization overhead on every call (even after the instance exists)

---

### 4. Bill Pugh / Class Holder Pattern
**File:** `HolderSingleton.java`

Uses a **static inner class** whose class loading is deferred until `getInstance()` is called. JVM guarantees thread-safe class initialization.

```java
public class HolderSingleton {
    private HolderSingleton() {}
    private static class Holder {
        static final HolderSingleton INSTANCE = new HolderSingleton();
    }
    public static HolderSingleton getInstance() { return Holder.INSTANCE; }
}
```

**Pros:** Lazy + thread-safe + no synchronization overhead  
**Cons:** Slightly less obvious to unfamiliar readers

---

### 5. Enum Singleton
**File:** `EnumSingleton.java`

The **recommended** approach by Joshua Bloch (*Effective Java*). The JVM guarantees enums are instantiated exactly once and are serialization-safe.

```java
public enum EnumSingleton {
    INSTANCE;
    public void doSomething() { ... }
}
```

**Pros:** Thread-safe, serialization-safe, reflection-proof, concise  
**Cons:** Cannot extend another class (enums can't inherit)

---

## Comparison

| Variant | Lazy? | Thread-Safe? | Recommended? |
|---------|-------|-------------|--------------|
| Eager | No | Yes | Simple cases |
| Lazy | Yes | No | Never in production |
| Synchronized Lazy | Yes | Yes | Avoid (slow) |
| Class Holder | Yes | Yes | Good choice |
| Enum | Effectively eager | Yes | **Best practice** |
