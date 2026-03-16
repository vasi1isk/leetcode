# Multithreading

Package: `com.multithreading`

Concurrency patterns and common pitfalls in Java — covering memory visibility, atomic operations, deadlocks, and the producer-consumer pattern.

---

## Examples

### Volatile Keyword — Memory Visibility
**File:** `VolatileExample.java`

Demonstrates why a plain `boolean` flag can be cached by a thread's local CPU cache, causing an infinite loop. Marking the flag `volatile` forces all threads to read from main memory, fixing the visibility issue.

!!! warning "Key insight"
    `volatile` guarantees **visibility** but NOT **atomicity**. Use it only for flags or single-variable state, never for compound check-then-act operations.

---

### Atomic Operations
**File:** `AtomicOperations.java`

Compares a non-synchronized counter (`int`) vs. `AtomicInteger.incrementAndGet()` across multiple threads. Shows that the plain counter produces incorrect results due to race conditions, while `AtomicInteger` guarantees correctness using CAS (Compare-And-Swap) hardware instructions.

---

### Bank Account — Volatile + Race Condition
**File:** `BankAccount.java`

Multi-threaded bank account withdrawal example. Illustrates how a `volatile` balance field alone is insufficient for compound operations (read-check-write), leading to over-withdrawal. The fix requires `synchronized` blocks or `AtomicInteger`.

---

### Deadlock Example
**File:** `DeadlockExample.java`

Creates two threads that acquire two locks in **opposite orders**, producing a circular wait (deadlock). Neither thread can proceed.

**Prevention strategies:**
- Always acquire locks in a consistent global order
- Use `tryLock()` with a timeout (`ReentrantLock`)
- Reduce lock scope

---

### Producer-Consumer
**File:** `ProducerConsumer.java`

Classic bounded-buffer producer-consumer implemented with a `synchronized` queue and `wait()`/`notifyAll()`:

- **Producer** adds items; calls `wait()` when the buffer is full
- **Consumer** removes items; calls `wait()` when the buffer is empty
- Each side calls `notifyAll()` after mutating the buffer

---

### Thread Pool — ExecutorService
**File:** `ThreadPoolExample.java`

Submits multiple `Runnable` tasks to a `Executors.newFixedThreadPool(n)`. Uses `executor.shutdown()` + `awaitTermination()` to wait for all tasks to complete before printing results.

---

## Concepts at a Glance

| Concept | File | Java Mechanism |
|---------|------|---------------|
| Memory visibility | `VolatileExample` | `volatile` |
| Atomic counter | `AtomicOperations` | `AtomicInteger` |
| Race condition on balance | `BankAccount` | `volatile` (insufficient) |
| Deadlock | `DeadlockExample` | `synchronized` circular wait |
| Producer-Consumer | `ProducerConsumer` | `wait` / `notifyAll` |
| Thread pool | `ThreadPoolExample` | `ExecutorService` |
