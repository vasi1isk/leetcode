# Basic Data Structures & Algorithms

Package: `com.basic`

Foundational implementations covering shuffling, prime generation, random sampling, stack-based validation, and randomized data structures.

---

## Implementations

### Fisher-Yates Card Shuffle
**File:** `OptimalCardShuffle.java`

Shuffles a standard 52-card deck in **O(n)** using the Fisher-Yates algorithm. For each position `i` from n−1 down to 1, swaps `deck[i]` with a randomly chosen `deck[j]` where `j ≤ i`. Guarantees a uniform random permutation.

**Time:** O(n) | **Space:** O(1) in-place

---

### Sieve of Eratosthenes
**File:** `OptimalPrimeGenerator.java`

Generates all prime numbers up to a given maximum using the classic sieve. Marks multiples of each discovered prime as composite, leaving only primes unmarked.

**Time:** O(n log log n) | **Space:** O(n)

---

### Random Number Generator Without Replacement
**File:** `OptimalRandomGenerator.java`

Produces a sequence of unique random numbers from a range using the Fisher-Yates partial shuffle. Each call draws the next number and moves it out of the available pool.

**Time:** O(1) per draw | **Space:** O(n)

---

### Balanced Parentheses Validator
**File:** `Parentheses.java`

Generic stack-based validator for `()`, `[]`, and `{}`. Pushes opening brackets onto a `Deque`; on a closing bracket, checks that the top of the stack matches.

**Time:** O(n) | **Space:** O(n)

---

### Randomized Set — O(1) Operations
**File:** `RandomizedSet.java`

Implements a set supporting:

- `insert(val)` — O(1) amortized
- `remove(val)` — O(1) amortized
- `getRandom()` — O(1) uniform

**Implementation:** `ArrayList` for indexed random access + `HashMap<value → index>` for O(1) lookup. On removal, swaps the target with the last element before deletion to avoid shifting.

---

### Reservoir Sampling — Random Pick Index
**File:** `RandomPickIndex.java`

Given an array with duplicate values, picks a **uniformly random** index of a target value using **Knuth's reservoir sampling** (Algorithm R). Processes the array in a single pass without storing matching indices — O(1) extra space.

**Time:** O(n) | **Space:** O(1)

---

## Summary Table

| File | Algorithm | Time | Space |
|------|-----------|------|-------|
| `OptimalCardShuffle` | Fisher-Yates shuffle | O(n) | O(1) |
| `OptimalPrimeGenerator` | Sieve of Eratosthenes | O(n log log n) | O(n) |
| `OptimalRandomGenerator` | Fisher-Yates partial shuffle | O(1)/draw | O(n) |
| `Parentheses` | Stack validation | O(n) | O(n) |
| `RandomizedSet` | ArrayList + HashMap | O(1) amortized | O(n) |
| `RandomPickIndex` | Reservoir sampling | O(n) | O(1) |
