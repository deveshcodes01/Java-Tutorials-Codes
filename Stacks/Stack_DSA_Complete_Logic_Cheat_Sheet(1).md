# Stack DSA — Complete Logic Cheat Sheet

A practical guide to recognizing and solving common **Stack DSA patterns in Java**.

---

## 1. When Should You Use a Stack?

Think:

> **Stack = LIFO (Last In, First Out)**

Use a stack when the problem involves:

- Matching opening and closing elements
- Parentheses or brackets
- Undo operations
- Previous/next greater or smaller elements
- Nested structures
- Reversing something
- Maintaining a sequence of candidates
- Removing elements based on a condition
- Expression evaluation/conversion
- Histogram / rectangle problems
- Simulations involving collisions or elimination

---

## 2. Basic Stack Template

### Java

```java
Deque<Integer> st = new ArrayDeque<>();

st.push(10);
st.push(20);

int x = st.pop();
int top = st.peek();

boolean empty = st.isEmpty();
```

`Deque` with `ArrayDeque` is generally preferred over the legacy `Stack` class.

---

# 3. Pattern 1 — Matching Parentheses

### Problem Types

- Valid Parentheses
- Remove outer parentheses
- Minimum brackets to remove
- Longest valid parentheses
- Balanced symbols

### Logic

Opening bracket → **Push**

Closing bracket → **Check + Pop**

```java
Stack<Character> st = new Stack<>();

for (char ch : s.toCharArray()) {

    if (ch == '(' || ch == '[' || ch == '{') {
        st.push(ch);
    } else {
        if (st.isEmpty()) {
            return false;
        }

        char top = st.pop();

        if ((ch == ')' && top != '(') ||
            (ch == ']' && top != '[') ||
            (ch == '}' && top != '{')) {
            return false;
        }
    }
}

return st.isEmpty();
```

### Remember

> **Opening → Push**  
> **Closing → Match + Pop**

---

# 4. Pattern 2 — Parentheses Without a Stack

If there is only one type of bracket, a counter is often enough.

```java
int balance = 0;

for (char ch : s.toCharArray()) {

    if (ch == '(') {
        balance++;
    } else {
        balance--;

        if (balance < 0) {
            return false;
        }
    }
}

return balance == 0;
```

### Key Idea

- `(` → `balance++`
- `)` → `balance--`
- If balance becomes negative → invalid
- At the end, balance must be `0`

---

# 5. Pattern 3 — Reverse a String

A stack naturally reverses data.

```text
Input:  ABC
Push:   A B C
Pop:    C B A
```

### Logic

> Push everything → Pop everything

```java
Stack<Character> st = new Stack<>();

for (char ch : s.toCharArray()) {
    st.push(ch);
}

StringBuilder ans = new StringBuilder();

while (!st.isEmpty()) {
    ans.append(st.pop());
}

return ans.toString();
```

---

# 6. Pattern 4 — Previous Greater Element

Example:

```text
[4, 5, 2, 10]
```

For every element, find the first greater element on its left.

### Logic

Traverse from **left to right**.

Remove elements that cannot be the answer:

```java
while (!st.isEmpty() && st.peek() <= arr[i]) {
    st.pop();
}
```

Then:

```java
ans[i] = st.isEmpty() ? -1 : st.peek();
```

Finally:

```java
st.push(arr[i]);
```

### Template

```java
Stack<Integer> st = new Stack<>();

for (int i = 0; i < n; i++) {

    while (!st.isEmpty() && st.peek() <= arr[i]) {
        st.pop();
    }

    ans[i] = st.isEmpty() ? -1 : st.peek();

    st.push(arr[i]);
}
```

---

# 7. Pattern 5 — Previous Smaller Element

Traverse **left to right**.

Pop elements greater than or equal to the current element.

```java
while (!st.isEmpty() && st.peek() >= arr[i]) {
    st.pop();
}
```

Then:

```java
ans[i] = st.isEmpty() ? -1 : st.peek();
```

---

# 8. Pattern 6 — Next Greater Element

Find the first greater element on the right.

### Main Trick

Traverse from **right to left**.

```java
for (int i = n - 1; i >= 0; i--) {

    while (!st.isEmpty() && st.peek() <= arr[i]) {
        st.pop();
    }

    ans[i] = st.isEmpty() ? -1 : st.peek();

    st.push(arr[i]);
}
```

---

# 9. Pattern 7 — Next Smaller Element

Traverse from **right to left**.

```java
for (int i = n - 1; i >= 0; i--) {

    while (!st.isEmpty() && st.peek() >= arr[i]) {
        st.pop();
    }

    ans[i] = st.isEmpty() ? -1 : st.peek();

    st.push(arr[i]);
}
```

---

# 10. The Four Monotonic Stack Templates

| Problem | Direction | Pop Condition |
|---|---|---|
| Previous Greater | Left → Right | `<= current` |
| Previous Smaller | Left → Right | `>= current` |
| Next Greater | Right → Left | `<= current` |
| Next Smaller | Right → Left | `>= current` |

### Memorize This Table

```text
Previous Greater  → L → R → pop <=
Previous Smaller  → L → R → pop >=
Next Greater      → R → L → pop <=
Next Smaller      → R → L → pop >=
```

---

# 11. Pattern 8 — Monotonic Stack

A monotonic stack keeps useful elements in increasing or decreasing order.

### Increasing Stack

```text
1
2
4
7
```

### Decreasing Stack

```text
9
7
5
2
```

### Think Monotonic Stack When You See:

- Next greater
- Next smaller
- Previous greater
- Previous smaller
- Nearest greater
- Nearest smaller
- First bigger element
- First smaller element
- Daily temperatures
- Stock span
- Histogram
- Remove elements to make a sequence optimal

---

# 12. Pattern 9 — Next Greater Element II

For a circular array:

```text
[1, 2, 1]
```

The last element can see the first element.

### Trick

Pretend the array occurs twice.

```java
for (int i = 2 * n - 1; i >= 0; i--) {

    int index = i % n;

    while (!st.isEmpty() && st.peek() <= arr[index]) {
        st.pop();
    }

    if (i < n) {
        ans[index] = st.isEmpty() ? -1 : st.peek();
    }

    st.push(arr[index]);
}
```

### Remember

> Circular array → `2 * n` iterations + `% n`

---

# 13. Pattern 10 — Stock Span

Example:

```text
[100, 80, 60, 70, 60, 75, 85]
```

Find how many consecutive previous days have price less than or equal to today's price.

### Important

For span problems, **store indices**, not just values.

```java
Stack<Integer> st = new Stack<>();

for (int i = 0; i < n; i++) {

    while (!st.isEmpty() && price[st.peek()] <= price[i]) {
        st.pop();
    }

    if (st.isEmpty()) {
        span[i] = i + 1;
    } else {
        span[i] = i - st.peek();
    }

    st.push(i);
}
```

---

# 14. Pattern 11 — Daily Temperatures

Question:

> How many days until a warmer temperature?

This is:

> **Next Greater Element + Distance**

```java
Stack<Integer> st = new Stack<>();

for (int i = 0; i < n; i++) {

    while (!st.isEmpty() &&
           temperatures[st.peek()] < temperatures[i]) {

        int index = st.pop();

        ans[index] = i - index;
    }

    st.push(i);
}
```

### Key Idea

If the problem asks:

> "How far away is the next greater element?"

Use:

```text
Monotonic Stack + Indices
```

---

# 15. Pattern 12 — Remove K Digits

Example:

```text
num = "1432219"
k = 3
```

Goal:

```text
1219
```

### Logic

We want the smallest number.

If:

```text
previous digit > current digit
```

remove the previous digit while `k > 0`.

```java
while (!st.isEmpty()
       && k > 0
       && st.peek() > ch) {

    st.pop();
    k--;
}

st.push(ch);
```

### Key Idea

> Remove a bigger previous element when a smaller current element arrives.

This is:

> **Greedy + Monotonic Stack**

---

# 16. Pattern 13 — Remove Duplicate Letters

Goal:

Create the smallest lexicographical string while keeping every character once.

### Logic

If:

```text
stack.top > current
```

and the top character appears again later, pop it.

```java
while (!st.isEmpty()
       && st.peek() > ch
       && count[st.peek()] > 0) {

    used[st.pop()] = false;
}
```

### Pattern

> **Greedy + Monotonic Stack + Frequency**

---

# 17. Pattern 14 — Largest Rectangle in Histogram

Example:

```text
[2, 1, 5, 6, 2, 3]
```

For every bar, determine how far it can extend left and right.

You need:

```text
Previous Smaller
+
Next Smaller
```

Then:

```text
width = right - left - 1
area  = height * width
```

### Core Template

```java
Stack<Integer> st = new Stack<>();

for (int i = 0; i <= n; i++) {

    int curr = (i == n) ? 0 : heights[i];

    while (!st.isEmpty() && heights[st.peek()] > curr) {

        int h = heights[st.pop()];

        int right = i;
        int left = st.isEmpty() ? -1 : st.peek();

        int width = right - left - 1;

        maxArea = Math.max(maxArea, h * width);
    }

    st.push(i);
}
```

### Remember

> Histogram → Previous Smaller + Next Smaller

---

# 18. Pattern 15 — Maximal Rectangle

For a binary matrix, convert every row into a histogram.

```text
Matrix
   ↓
Histogram for each row
   ↓
Largest Rectangle in Histogram
```

### Key Idea

For each row:

1. Update heights of consecutive `1`s.
2. Run Largest Rectangle in Histogram.
3. Keep the maximum area.

---

# 19. Pattern 16 — Evaluate Postfix Expression

Example:

```text
2 3 + 4 *
```

Result:

```text
20
```

### Logic

Number → Push

Operator → Pop two values, calculate, push result.

```java
int a = st.pop();
int b = st.pop();

int result = b - a; // example

st.push(result);
```

### Important

For `-` and `/`, order matters:

```text
b - a
b / a
```

NOT:

```text
a - b
a / b
```

---

# 20. Pattern 17 — Infix to Postfix

Example:

```text
A + B * C
```

Output:

```text
ABC*+
```

### Rules

```text
Operand → Output directly
Operator → Push to stack
'(' → Push
')' → Pop until '('
```

### Operator Precedence

```text
^
*
/
+
-
```

### Core Logic

```java
while (!st.isEmpty() &&
       precedence(st.peek()) >= precedence(ch)) {

    output.append(st.pop());
}

st.push(ch);
```

---

# 21. Pattern 18 — Min Stack

Problem:

> Implement a stack that returns the minimum element in O(1).

### Approach

Maintain two stacks:

```text
Normal Stack
Min Stack
```

When pushing:

```java
minStack.push(
    Math.min(x, minStack.peek())
);
```

### Complexity

```text
push    → O(1)
pop     → O(1)
top     → O(1)
getMin  → O(1)
```

---

# 22. Pattern 19 — Two Stacks in One Array

Use one array:

```text
Stack 1 → starts from left
Stack 2 → starts from right
```

Conceptually:

```text
→ → → →       ← ← ← ←
 Stack 1       Stack 2
```

Overflow occurs when:

```text
top1 + 1 == top2
```

---

# 23. Pattern 20 — Queue Using Two Stacks

Use:

```text
stack1
stack2
```

### Enqueue

Push into `stack1`.

### Dequeue

If `stack2` is empty:

```text
Move everything from stack1 → stack2
```

Then:

```text
pop stack2
```

### Why It Works

```text
stack1: 1 2 3
```

Move to stack2:

```text
3 2 1 → 1 2 3
```

This creates FIFO behavior.

---

# 24. Pattern 21 — Stack Using Queues

To implement a stack using queues:

For push:

1. Enqueue the new element.
2. Rotate previous elements behind it.
3. The newest element becomes the front.

Then:

```text
pop = dequeue
```

---

# 25. Pattern 22 — Decode String

Example:

```text
3[a2[c]]
```

Output:

```text
accaccacc
```

### Use Two Stacks

One stack stores:

```text
numbers
```

Another stores:

```text
strings
```

When you see:

```text
[
```

save the current state.

When you see:

```text
]
```

restore the previous state.

### Think

> Nested structure → Stack

---

# 26. Pattern 23 — Simplify Unix Path

Example:

```text
/home/user/../documents
```

Output:

```text
/home/documents
```

### Rules

```text
".." → pop
"."  → ignore
name → push
```

### Pattern

> Path navigation → Stack

---

# 27. Pattern 24 — Backspace String Compare

Example:

```text
ab#c
ad#c
```

Both become:

```text
ac
```

### Logic

```java
Stack<Character> st = new Stack<>();

for (char ch : s.toCharArray()) {

    if (ch == '#') {
        if (!st.isEmpty()) {
            st.pop();
        }
    } else {
        st.push(ch);
    }
}
```

---

# 28. Pattern 25 — Celebrity Problem

A celebrity:

```text
Everyone knows them
They know nobody
```

### Stack Elimination

Push everyone.

Take two candidates:

```text
a
b
```

If:

```text
a knows b
```

then `a` cannot be the celebrity.

Otherwise:

```text
b` cannot be the celebrity.
```

Keep eliminating candidates until one remains.

Then verify the remaining candidate.

### Key Idea

> Stack can be used for **candidate elimination**.

---

# 29. Pattern 26 — Asteroid Collision

Example:

```text
[5, 10, -5]
```

Positive → moving right.

Negative → moving left.

Collision can happen when:

```text
stack.top > 0
current < 0
```

### Core Logic

```java
while (!st.isEmpty()
       && st.peek() > 0
       && curr < 0
       && st.peek() < -curr) {

    st.pop();
}
```

Then handle equal/larger magnitudes.

### Pattern

> **Simulation + Stack**

---

# 30. Values vs Indices

This is one of the most important decisions.

## Use Values When

You only need:

```text
Greater/smaller VALUE
```

Example:

```text
Next Greater Element
```

## Use Indices When

You need:

```text
Distance
Width
Position
Range
```

Examples:

```text
Daily Temperatures
Stock Span
Largest Rectangle
```

### Rule

> Need distance/width/range? **Store indices.**

---

# 31. Why Monotonic Stack Is O(n)

A common mistake is seeing:

```java
for (...) {
    while (...) {
        st.pop();
    }
}
```

and assuming:

```text
O(n²)
```

Usually, a monotonic stack is:

```text
O(n)
```

because every element is:

```text
Pushed once
Popped at most once
```

Therefore:

```text
n pushes + n pops
= O(n)
```

### Important

> **Nested `while` does NOT automatically mean O(n²).**

---

# 32. Stack Problem Decision Tree

When you see a Stack problem, ask:

## Step 1 — Is it about brackets?

```text
YES → Stack
```

## Step 2 — Is it nested?

Examples:

```text
3[a2[c]]
((()))
/a/b/../c
```

```text
YES → Stack
```

## Step 3 — Is it asking for nearest/next/previous greater or smaller?

```text
YES → Monotonic Stack
```

## Step 4 — Do you need distance, width, or position?

```text
YES → Store indices
```

## Step 5 — Is the array circular?

```text
YES → 2*n iterations + % n
```

## Step 6 — Are you removing previous elements greedily?

```text
YES → Monotonic Stack + Greedy
```

## Step 7 — Do you need min/max in O(1)?

```text
YES → Second Stack / Extra State
```

## Step 8 — Is it an expression?

```text
YES → Stack
```

---

# 33. Ultimate Stack Cheat Sheet

```text
Parentheses
    ↓
Stack

Nested Structure
    ↓
Stack

Reverse
    ↓
Stack

Previous/Next Greater
    ↓
Monotonic Stack

Previous/Next Smaller
    ↓
Monotonic Stack

Need Distance/Width
    ↓
Store Indices

Circular Array
    ↓
2*n + %

Remove Previous Elements Greedily
    ↓
Monotonic Stack

Histogram
    ↓
Previous Smaller + Next Smaller

Matrix Rectangle
    ↓
Histogram + Stack

Expression Evaluation
    ↓
Stack

Min/Max in O(1)
    ↓
Two Stacks / Extra State

Nested Decoding
    ↓
Two Stacks

Collision / Simulation
    ↓
Stack
```

---

# 34. Most Important Rule

When you see:

> **"Find the first / nearest / next / previous greater or smaller element"**

Immediately think:

# MONOTONIC STACK

And when the problem asks for:

> **Distance, width, range, or position**

think:

# STORE INDICES

---

# 35. Recommended Practice Order

## Easy

1. Valid Parentheses
2. Remove Outermost Parentheses
3. Implement Stack
4. Implement Queue Using Stacks
5. Backspace String Compare
6. Baseball Game

## Medium

7. Next Greater Element I
8. Next Greater Element II
9. Daily Temperatures
10. Stock Span
11. Min Stack
12. Simplify Path
13. Decode String
14. Asteroid Collision
15. Remove K Digits

## Hard / Important

16. Largest Rectangle in Histogram
17. Maximal Rectangle
18. Trapping Rain Water
19. Basic Calculator
20. Basic Calculator II
21. Remove Duplicate Letters
22. Sum of Subarray Minimums
23. Largest Rectangle Variants

---

# Quick Revision

Before solving any Stack problem, ask:

```text
1. Is there nesting?
2. Is there matching?
3. Is there a previous/next element?
4. Is it greater or smaller?
5. Do I need the nearest one?
6. Do I need distance/width?
7. Should I store values or indices?
8. Is the array circular?
9. Am I greedily removing elements?
10. Can each element be pushed/popped only once?
```

If the answer points toward one of the patterns above, the Stack solution is usually close.
