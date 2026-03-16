# Algorithms

Package: `com.algorithms`

Classic algorithm problems, mostly LeetCode-style, covering sliding window, interval merging, string manipulation, and rate limiting.

---

## Problems

### Longest Substring Without Repeating Characters
**File:** `LongestSubstring.java`

Uses a **sliding window** with a `HashSet` to track unique characters. Expands the right pointer and shrinks the left when a duplicate is found. Returns the maximum window size seen.

**Time:** O(n) | **Space:** O(min(n, m)) where m = charset size

---

### Max Number in Array
**File:** `MaxNumberInArray.java`

Single-pass linear scan through an array, tracking the running maximum.

**Time:** O(n) | **Space:** O(1)

---

### Merge Intervals
**File:** `MergeIntervals.java`

Sort intervals by start time, then iterate and merge overlapping intervals by extending the end boundary when `currentEnd >= nextStart`.

**Time:** O(n log n) | **Space:** O(n)

---

### Message Delivery Status
**File:** `MessageDeliveryStatus.java`

Custom problem: checks whether a message can be delivered given per-user rate limits. Uses a `HashMap` to track delivered message counts per user.

---

### Palindromic Subsequences
**File:** `Pallindrom.java`

Counts palindromic subsequences in a string. Uses dynamic programming / recursive exploration.

---

### Roman Numerals to Integer
**File:** `RomanNumbers.java`

Converts a Roman numeral string to an integer. Handles subtraction rules (e.g. `IV = 4`, `CM = 900`) by checking if the current symbol is less than the next.

**Time:** O(n) | **Space:** O(1)

---

## Key Patterns Used

| Pattern | Used In |
|---------|---------|
| Sliding Window | `LongestSubstring` |
| Sorting + Greedy | `MergeIntervals` |
| HashMap lookup | `MessageDeliveryStatus` |
| String traversal | `RomanNumbers`, `Pallindrom` |
