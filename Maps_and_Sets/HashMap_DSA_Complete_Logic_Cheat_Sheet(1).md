# HashMap DSA — Complete Logic Cheat Sheet

A practical guide to recognizing and solving common **HashMap / HashSet DSA patterns in Java**.

---

# 1. What Is a HashMap?

A `HashMap` stores:

```text
Key → Value
```

Example:

```java
Map<String, Integer> map = new HashMap<>();

map.put("apple", 3);
map.put("banana", 5);

int x = map.get("apple");
```

Average complexity:

```text
put    → O(1)
get    → O(1)
remove → O(1)
containsKey → O(1)
```

---

# 2. When Should You Think HashMap?

Immediately think HashMap when the problem involves:

- Frequency/count
- Duplicate detection
- Fast lookup
- Pair finding
- Complement finding
- Mapping one thing to another
- Grouping
- Counting subarrays
- Prefix sums
- Character frequencies
- Anagrams
- Caching
- Last seen index
- Tracking states

---

# 3. Basic HashMap Template

```java
Map<Integer, Integer> map = new HashMap<>();

map.put(10, 100);

int value = map.get(10);

if (map.containsKey(10)) {
    // exists
}

map.remove(10);
```

For frequency:

```java
map.put(x, map.getOrDefault(x, 0) + 1);
```

This one line is extremely important.

---

# 4. Pattern 1 — Frequency Counting

If the problem asks:

> How many times does each element appear?

Use:

```java
Map<Integer, Integer> freq = new HashMap<>();

for (int x : arr) {
    freq.put(x, freq.getOrDefault(x, 0) + 1);
}
```

For characters:

```java
Map<Character, Integer> freq = new HashMap<>();

for (char ch : s.toCharArray()) {
    freq.put(ch, freq.getOrDefault(ch, 0) + 1);
}
```

### Think

> **Count → HashMap**

---

# 5. Pattern 2 — Find Duplicates

Example:

```text
[1, 2, 3, 2, 4]
```

Need to detect repeated values.

### Option 1 — HashSet

```java
Set<Integer> set = new HashSet<>();

for (int x : arr) {

    if (set.contains(x)) {
        return true;
    }

    set.add(x);
}

return false;
```

### Think

> Only need existence → **HashSet**

> Need frequency → **HashMap**

---

# 6. Pattern 3 — Two Sum

Classic HashMap problem.

Example:

```text
[2, 7, 11, 15]
target = 9
```

Need:

```text
2 + 7 = 9
```

### Logic

For every number:

```text
complement = target - current
```

Check whether complement already exists.

```java
Map<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < nums.length; i++) {

    int complement = target - nums[i];

    if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
    }

    map.put(nums[i], i);
}
```

### Pattern

> **Target pair → Complement lookup**

---

# 7. Pattern 4 — Count Pairs With a Target

Instead of storing indices, store frequencies.

Example:

```text
arr = [1, 5, 7, -1]
target = 6
```

For every number:

```text
needed = target - current
```

Add the frequency of `needed`.

```java
Map<Integer, Integer> freq = new HashMap<>();
int count = 0;

for (int x : arr) {

    int needed = target - x;

    count += freq.getOrDefault(needed, 0);

    freq.put(x, freq.getOrDefault(x, 0) + 1);
}
```

### Difference

```text
Two Sum → store index
Pair count → store frequency
```

---

# 8. Pattern 5 — Anagram

Two strings are anagrams if they contain the same characters with the same frequencies.

Example:

```text
listen
silent
```

### Logic

Count characters.

```java
Map<Character, Integer> map = new HashMap<>();

for (char ch : s.toCharArray()) {
    map.put(ch, map.getOrDefault(ch, 0) + 1);
}

for (char ch : t.toCharArray()) {

    if (!map.containsKey(ch)) {
        return false;
    }

    map.put(ch, map.get(ch) - 1);

    if (map.get(ch) == 0) {
        map.remove(ch);
    }
}

return map.isEmpty();
```

### Think

> **Same characters + same frequency → HashMap**

---

# 9. Pattern 6 — Group Anagrams

Example:

```text
eat
tea
ate
tan
nat
```

Group:

```text
[eat, tea, ate]
[tan, nat]
```

### Key Idea

Create a common key.

One approach:

```text
Sort each string
```

Example:

```text
eat → aet
tea → aet
ate → aet
```

Then:

```text
aet → [eat, tea, ate]
```

### Java

```java
Map<String, List<String>> map = new HashMap<>();

for (String s : strs) {

    char[] chars = s.toCharArray();
    Arrays.sort(chars);

    String key = new String(chars);

    map.computeIfAbsent(key, k -> new ArrayList<>())
       .add(s);
}
```

### Pattern

> **Grouping → Create a unique/common key**

---

# 10. Pattern 7 — First Unique Character

Need the first character whose frequency is `1`.

### Two-pass approach

Pass 1:

```text
Count frequencies
```

Pass 2:

```text
Find first frequency == 1
```

```java
Map<Character, Integer> freq = new HashMap<>();

for (char ch : s.toCharArray()) {
    freq.put(ch, freq.getOrDefault(ch, 0) + 1);
}

for (int i = 0; i < s.length(); i++) {

    if (freq.get(s.charAt(i)) == 1) {
        return i;
    }
}

return -1;
```

### Pattern

> **Frequency + original order**

---

# 11. Pattern 8 — Last Seen Index

Many substring problems require knowing:

> Where was this character last seen?

Use:

```java
Map<Character, Integer> last = new HashMap<>();
```

Then:

```java
last.put(ch, i);
```

Example:

```text
abcabcbb
```

When duplicate `a` appears:

```text
last[a]
```

tells you where the previous `a` occurred.

### Think

> **"Last occurrence" → HashMap**

---

# 12. Pattern 9 — Longest Substring Without Repeating Characters

Classic sliding-window + HashMap problem.

### Logic

Maintain:

```text
left
right
last seen index
```

When current character was already seen inside the window:

```text
left = lastSeen + 1
```

### Java

```java
Map<Character, Integer> lastSeen = new HashMap<>();

int left = 0;
int maxLen = 0;

for (int right = 0; right < s.length(); right++) {

    char ch = s.charAt(right);

    if (lastSeen.containsKey(ch)) {
        left = Math.max(left, lastSeen.get(ch) + 1);
    }

    lastSeen.put(ch, right);

    maxLen = Math.max(maxLen, right - left + 1);
}
```

### Pattern

> **Substring + unique characters → Sliding Window + HashMap**

---

# 13. Pattern 10 — Longest Substring With K Distinct Characters

Use:

```text
Sliding Window + HashMap frequency
```

Expand right.

Count characters.

If:

```text
map.size() > k
```

shrink from left.

```java
Map<Character, Integer> freq = new HashMap<>();

int left = 0;
int maxLen = 0;

for (int right = 0; right < s.length(); right++) {

    char ch = s.charAt(right);
    freq.put(ch, freq.getOrDefault(ch, 0) + 1);

    while (freq.size() > k) {

        char leftChar = s.charAt(left);

        freq.put(leftChar, freq.get(leftChar) - 1);

        if (freq.get(leftChar) == 0) {
            freq.remove(leftChar);
        }

        left++;
    }

    maxLen = Math.max(maxLen, right - left + 1);
}
```

---

# 14. Pattern 11 — Prefix Sum + HashMap

One of the most important HashMap patterns.

Suppose you need:

> Count subarrays whose sum equals `k`.

### Key Equation

If:

```text
prefixSum[j] - prefixSum[i] = k
```

then:

```text
prefixSum[i] = prefixSum[j] - k
```

So while traversing:

```text
needed = currentPrefix - k
```

Look for `needed` in the HashMap.

### Java

```java
Map<Integer, Integer> map = new HashMap<>();

map.put(0, 1);

int prefix = 0;
int count = 0;

for (int x : nums) {

    prefix += x;

    count += map.getOrDefault(prefix - k, 0);

    map.put(prefix, map.getOrDefault(prefix, 0) + 1);
}
```

### Very Important

Initialize:

```java
map.put(0, 1);
```

This handles subarrays starting at index `0`.

---

# 15. Pattern 12 — Longest Subarray With Sum K

Similar to the previous pattern.

But instead of storing frequency, store the **first index** where each prefix sum appeared.

```java
Map<Integer, Integer> map = new HashMap<>();

map.put(0, -1);

int prefix = 0;
int maxLen = 0;

for (int i = 0; i < nums.length; i++) {

    prefix += nums[i];

    if (map.containsKey(prefix - k)) {
        maxLen = Math.max(
            maxLen,
            i - map.get(prefix - k)
        );
    }

    map.putIfAbsent(prefix, i);
}
```

### Key Difference

```text
Count subarrays → frequency
Longest subarray → first index
```

---

# 16. Pattern 13 — Subarray Sum Divisible by K

If:

```text
prefix % k
```

has appeared before, the elements between those positions have a sum divisible by `k`.

### Logic

Store frequency of remainders.

```java
Map<Integer, Integer> freq = new HashMap<>();

freq.put(0, 1);

int prefix = 0;
int count = 0;

for (int x : nums) {

    prefix += x;

    int rem = prefix % k;

    if (rem < 0) {
        rem += k;
    }

    count += freq.getOrDefault(rem, 0);

    freq.put(rem, freq.getOrDefault(rem, 0) + 1);
}
```

### Pattern

> **Prefix Sum + Same Remainder**

---

# 17. Pattern 14 — Longest Consecutive Sequence

Example:

```text
[100, 4, 200, 1, 3, 2]
```

Answer:

```text
1, 2, 3, 4
```

### Use HashSet

Put all numbers into a set.

Only start counting when:

```text
x - 1
```

does not exist.

```java
Set<Integer> set = new HashSet<>();

for (int x : nums) {
    set.add(x);
}

int longest = 0;

for (int x : set) {

    if (!set.contains(x - 1)) {

        int current = x;
        int length = 1;

        while (set.contains(current + 1)) {
            current++;
            length++;
        }

        longest = Math.max(longest, length);
    }
}
```

### Key Idea

> Start only at the beginning of a sequence.

Average:

```text
O(n)
```

---

# 18. Pattern 15 — Intersection of Arrays

If you need to know whether an element exists:

```text
HashSet
```

If duplicates/frequencies matter:

```text
HashMap
```

Example:

```java
Set<Integer> set = new HashSet<>();

for (int x : nums1) {
    set.add(x);
}

for (int x : nums2) {

    if (set.contains(x)) {
        // common element
    }
}
```

---

# 19. Pattern 16 — Mapping One Thing to Another

HashMap is useful when you need:

```text
A → B
```

Examples:

```text
value → index
character → count
character → last index
number → frequency
student → marks
node → parent
```

### Generic Pattern

```java
Map<Key, Value> map = new HashMap<>();

map.put(key, value);
```

### Think

> **Need a relationship between two pieces of information → HashMap**

---

# 20. Pattern 17 — Two Sum With Indices

Store:

```text
number → index
```

```java
Map<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < nums.length; i++) {

    int needed = target - nums[i];

    if (map.containsKey(needed)) {
        return new int[]{map.get(needed), i};
    }

    map.put(nums[i], i);
}
```

### Important

Store before/after checking carefully depending on whether the same element can be reused.

---

# 21. Pattern 18 — Frequency + Sorting / Priority Queue

If the problem asks:

> Most frequent elements

First:

```text
HashMap → frequency
```

Then:

```text
PriorityQueue / sorting
```

Example:

```text
Top K Frequent Elements
```

Pattern:

```text
Array
 ↓
Frequency Map
 ↓
Heap / Sorting
 ↓
Top K
```

---

# 22. Pattern 19 — Top K Frequent Elements

### Step 1

Count frequency.

```java
Map<Integer, Integer> freq = new HashMap<>();

for (int x : nums) {
    freq.put(x, freq.getOrDefault(x, 0) + 1);
}
```

### Step 2

Use a min heap of size `k`.

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>(
        (a, b) -> freq.get(a) - freq.get(b)
    );
```

### Pattern

> **Frequency → HashMap → Top K → Heap**

---

# 23. Pattern 20 — Find Duplicate / Missing Values

Hashing can track:

```text
seen values
```

Example:

```java
Set<Integer> seen = new HashSet<>();

for (int x : nums) {

    if (seen.contains(x)) {
        // duplicate
    }

    seen.add(x);
}
```

Or use a frequency map when counts are needed.

---

# 24. Pattern 21 — Isomorphic Strings

Two strings are isomorphic if characters maintain a consistent mapping.

Example:

```text
egg
add
```

Mapping:

```text
e → a
g → d
```

Need to make sure mapping is one-to-one.

Use two maps or one map + set.

```java
Map<Character, Character> map = new HashMap<>();
Set<Character> used = new HashSet<>();

for (int i = 0; i < s.length(); i++) {

    char a = s.charAt(i);
    char b = t.charAt(i);

    if (map.containsKey(a)) {

        if (map.get(a) != b) {
            return false;
        }

    } else {

        if (used.contains(b)) {
            return false;
        }

        map.put(a, b);
        used.add(b);
    }
}

return true;
```

### Pattern

> **One-to-one relationship → HashMap + HashSet**

---

# 25. Pattern 22 — Word Pattern

Example:

```text
pattern = "abba"
string  = "dog cat cat dog"
```

Need:

```text
a → dog
b → cat
```

Again:

> **One-to-one mapping**

Use:

```text
Map<Character, String>
+
Set<String>
```

---

# 26. Pattern 23 — Subarray With Zero Sum

If the same prefix sum appears twice:

```text
prefix[i] == prefix[j]
```

then:

```text
sum(i+1 ... j) = 0
```

### Use HashSet

```java
Set<Integer> set = new HashSet<>();

int sum = 0;

set.add(0);

for (int x : nums) {

    sum += x;

    if (set.contains(sum)) {
        return true;
    }

    set.add(sum);
}

return false;
```

### Pattern

> **Repeated prefix sum → Zero-sum subarray**

---

# 27. Pattern 24 — Count Zero-Sum Subarrays

Same idea, but use frequency instead of a set.

```java
Map<Integer, Integer> freq = new HashMap<>();

freq.put(0, 1);

int sum = 0;
int count = 0;

for (int x : nums) {

    sum += x;

    count += freq.getOrDefault(sum, 0);

    freq.put(sum, freq.getOrDefault(sum, 0) + 1);
}
```

### Difference

```text
Existence → HashSet
Count     → HashMap frequency
```

---

# 28. Pattern 25 — Binary Array + Prefix Sum

For a binary array, problems involving equal numbers of `0` and `1` can often be transformed.

Convert:

```text
0 → -1
1 → +1
```

Then:

```text
Equal 0s and 1s
```

becomes:

```text
Subarray sum = 0
```

Then use:

```text
Prefix Sum + HashMap
```

### Powerful Transformation

> **Equal count of two things → Convert to +1 / -1 → Prefix Sum**

---

# 29. Pattern 26 — Sliding Window + HashMap

For problems like:

```text
Longest substring with constraints
Longest subarray with at most K distinct values
Minimum window substring
Character frequency constraints
```

Think:

```text
Sliding Window
+
HashMap frequency
```

General structure:

```java
Map<Character, Integer> freq = new HashMap<>();

int left = 0;

for (int right = 0; right < n; right++) {

    // Add right element
    freq.put(...);

    while (/* window invalid */) {

        // Remove left element
        freq.put(...);

        left++;
    }

    // Update answer
}
```

---

# 30. Pattern 27 — Minimum Window Substring

This is an advanced:

```text
Sliding Window + HashMap
```

pattern.

Maintain:

```text
required frequencies
window frequencies
formed / matched count
```

Expand `right`.

When the window contains everything required:

```text
Shrink left
```

while maintaining validity.

### Think

> **Minimum valid substring → Sliding Window + Frequency Map**

---

# 31. Pattern 28 — Cache / LRU Concept

HashMap is often combined with a doubly linked list.

Why?

HashMap gives:

```text
O(1) lookup
```

Linked list gives:

```text
O(1) removal/movement
```

Together:

```text
HashMap + Doubly Linked List
```

can implement:

```text
LRU Cache
```

### Pattern

> Need fast lookup + maintain usage order → HashMap + Linked List

---

# 32. HashMap vs HashSet

## HashSet

Use when you only care:

```text
Does it exist?
```

Example:

```java
Set<Integer> set = new HashSet<>();
```

## HashMap

Use when you care:

```text
key → information
```

Example:

```java
Map<Integer, Integer> map = new HashMap<>();
```

### Quick Rule

```text
Existence      → HashSet
Frequency      → HashMap
Index          → HashMap
Mapping        → HashMap
Last seen      → HashMap
Prefix sum     → HashMap
```

---

# 33. What Should the HashMap Store?

This is one of the most important decisions.

### Need frequency?

```text
value → count
```

### Need index?

```text
value → index
```

### Need last occurrence?

```text
value → last index
```

### Need first occurrence?

```text
value → first index
```

### Need mapping?

```text
A → B
```

### Need prefix-sum count?

```text
prefix → frequency
```

### Need longest subarray?

```text
prefix → first index
```

---

# 34. Prefix Sum + HashMap Cheat Sheet

This pattern is extremely important.

## Count subarrays with sum K

```text
prefix → frequency
```

Initialize:

```java
map.put(0, 1);
```

Lookup:

```text
prefix - k
```

---

## Longest subarray with sum K

```text
prefix → first index
```

Initialize:

```java
map.put(0, -1);
```

Lookup:

```text
prefix - k
```

---

## Zero-sum subarray existence

```text
prefix → HashSet
```

Check repeated prefix.

---

## Divisible by K

```text
prefix % k → frequency
```

Check repeated remainder.

---

# 35. HashMap Decision Tree

When you see a problem, ask:

### 1. Do I need frequency?

```text
YES → HashMap
```

### 2. Do I only need existence?

```text
YES → HashSet
```

### 3. Do I need a complement?

```text
YES → HashMap
```

Example:

```text
target - current
```

### 4. Do I need the last/first occurrence?

```text
YES → HashMap
```

### 5. Is it substring/subarray with constraints?

```text
YES → Sliding Window + HashMap
```

### 6. Is it about subarray sums?

```text
YES → Prefix Sum + HashMap
```

### 7. Does it ask for count?

```text
YES → Frequency Map
```

### 8. Does it ask for longest?

```text
Store first occurrence/index
```

### 9. Does it ask for top K frequent?

```text
HashMap + Heap
```

### 10. Is it one-to-one mapping?

```text
HashMap + HashSet
```

---

# 36. Complexity

Average HashMap operations:

```text
put           → O(1)
get           → O(1)
containsKey   → O(1)
remove        → O(1)
```

For `n` elements:

```text
Frequency counting → O(n)
Two Sum            → O(n)
Longest substring  → O(n)
Prefix sum problems → O(n)
```

Space is usually:

```text
O(n)
```

---

# 37. Common HashMap Mistakes

### Mistake 1 — Forgetting `getOrDefault`

Instead of:

```java
if (map.containsKey(x)) {
    map.put(x, map.get(x) + 1);
} else {
    map.put(x, 1);
}
```

Use:

```java
map.put(x, map.getOrDefault(x, 0) + 1);
```

---

### Mistake 2 — Using frequency when you need an index

For:

```text
Two Sum
Longest Subarray
Longest Substring
```

you may need:

```text
value → index
```

not just:

```text
value → count
```

---

### Mistake 3 — Storing the latest index when you need the earliest

For longest subarray problems:

```java
map.putIfAbsent(prefix, i);
```

Usually you want the **first occurrence** because it gives the longest possible range.

---

### Mistake 4 — Forgetting the initial prefix

For prefix sum problems:

```java
map.put(0, 1);
```

or:

```java
map.put(0, -1);
```

depending on whether you need:

```text
frequency
```

or:

```text
index
```

---

# 38. Ultimate HashMap Cheat Sheet

```text
Count Frequency
    ↓
HashMap

Only Existence
    ↓
HashSet

Two Sum / Target Pair
    ↓
Complement + HashMap

Anagram
    ↓
Character Frequency

Group Anagrams
    ↓
Common Key + HashMap

Last Occurrence
    ↓
HashMap

Longest Unique Substring
    ↓
Sliding Window + HashMap

K Distinct Characters
    ↓
Sliding Window + Frequency Map

Subarray Sum K
    ↓
Prefix Sum + Frequency Map

Longest Subarray Sum K
    ↓
Prefix Sum + First Index Map

Zero Sum Exists
    ↓
Prefix Sum + HashSet

Zero Sum Count
    ↓
Prefix Sum + Frequency Map

Equal 0s and 1s
    ↓
0 → -1, 1 → +1
    ↓
Prefix Sum + HashMap

Top K Frequent
    ↓
HashMap + PriorityQueue

One-to-One Mapping
    ↓
HashMap + HashSet

LRU Cache
    ↓
HashMap + Doubly Linked List
```

---

# 39. Most Important HashMap Rule

When you see:

> **"How many times?"**

Think:

# FREQUENCY MAP

When you see:

> **"Have I seen this before?"**

Think:

# HASHSET / HASHMAP

When you see:

> **"Find a pair that adds to target"**

Think:

# COMPLEMENT + HASHMAP

When you see:

> **"Longest subarray/substring"**

Think:

# SLIDING WINDOW or PREFIX SUM + HASHMAP

When you see:

> **"Count subarrays with sum K"**

Think:

# PREFIX SUM + FREQUENCY MAP

When you see:

> **"Top K frequent"**

Think:

# HASHMAP + HEAP

---

# 40. Recommended Practice Order

## Easy

1. Contains Duplicate
2. Two Sum
3. Valid Anagram
4. Intersection of Two Arrays
5. First Unique Character
6. Majority Element

## Medium

7. Group Anagrams
8. Longest Substring Without Repeating Characters
9. Longest Subarray With Sum K
10. Subarray Sum Equals K
11. Longest Consecutive Sequence
12. Top K Frequent Elements
13. Isomorphic Strings
14. Word Pattern
15. Subarray Sums Divisible by K

## Hard / Important

16. Minimum Window Substring
17. LRU Cache
18. Subarrays With K Different Integers
19. Count of Smaller / advanced frequency patterns
20. Advanced prefix-sum + hashing problems

---

# Quick Revision

Before solving a HashMap problem, ask:

```text
1. Do I need frequency?
2. Do I need existence?
3. Do I need an index?
4. Do I need first occurrence?
5. Do I need last occurrence?
6. Is there a target/complement?
7. Is it a substring/subarray?
8. Can prefix sum help?
9. Do I need frequency of prefix sums?
10. Do I need a sliding window?
11. Is it Top K?
12. Is it a one-to-one mapping?
```

If one of these patterns matches, the HashMap solution is usually close.
