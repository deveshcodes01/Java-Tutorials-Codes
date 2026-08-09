# Queue DSA — Complete Logic Cheat Sheet

A practical guide to recognizing and solving common **Queue DSA patterns in Java**.

---

## 1. When Should You Use a Queue?

Think:

> **Queue = FIFO (First In, First Out)**

Use a queue when the problem involves:

- First-come-first-served processing
- Level-by-level traversal
- Breadth First Search (BFS)
- Scheduling
- Simulations
- Processing elements in arrival order
- Sliding windows
- Shortest path in an unweighted graph
- Multi-source spreading problems
- Producer/consumer style processing

---

# 2. Basic Queue Template

For modern Java, prefer `Deque`:

```java
Deque<Integer> q = new ArrayDeque<>();

q.offer(10);
q.offer(20);

int x = q.poll();
int front = q.peek();

boolean empty = q.isEmpty();
```

### Main Operations

```text
offer() → insert
poll()  → remove front
peek()  → view front
isEmpty()
size()
```

---

# 3. Pattern 1 — Basic Queue Simulation

If the problem says:

> Process people/tasks/items in the order they arrive.

Think:

```text
Queue
```

Example:

```java
Queue<Integer> q = new LinkedList<>();

for (int x : arr) {
    q.offer(x);
}

while (!q.isEmpty()) {
    int current = q.poll();
    // process current
}
```

### Key Idea

> **First entered → First processed**

---

# 4. Pattern 2 — BFS in a Graph

One of the most important Queue patterns.

### Logic

1. Put the starting node into the queue.
2. Mark it visited.
3. Remove one node.
4. Process its neighbors.
5. Add unvisited neighbors.
6. Repeat.

```java
Queue<Integer> q = new LinkedList<>();
boolean[] visited = new boolean[n];

q.offer(start);
visited[start] = true;

while (!q.isEmpty()) {

    int node = q.poll();

    for (int next : graph[node]) {

        if (!visited[next]) {
            visited[next] = true;
            q.offer(next);
        }
    }
}
```

### Remember

> **BFS = Queue**

---

# 5. Pattern 3 — BFS Level Order

When the problem asks for:

- Level order
- Level by level
- Minimum number of steps
- Distance from source
- Nodes at each level

Think:

```text
BFS + Queue
```

### Binary Tree Template

```java
Queue<TreeNode> q = new LinkedList<>();
q.offer(root);

while (!q.isEmpty()) {

    int size = q.size();

    for (int i = 0; i < size; i++) {

        TreeNode node = q.poll();

        if (node.left != null) {
            q.offer(node.left);
        }

        if (node.right != null) {
            q.offer(node.right);
        }
    }
}
```

### Critical Trick

```java
int size = q.size();
```

This captures the number of nodes in the **current level**.

---

# 6. Pattern 4 — BFS Shortest Path in an Unweighted Graph

If every edge has equal cost:

```text
Shortest path → BFS
```

### Logic

The first time BFS reaches a node, it has found the shortest number of edges from the source.

```java
Queue<Integer> q = new LinkedList<>();
int[] dist = new int[n];

Arrays.fill(dist, -1);

q.offer(src);
dist[src] = 0;

while (!q.isEmpty()) {

    int node = q.poll();

    for (int next : graph[node]) {

        if (dist[next] == -1) {

            dist[next] = dist[node] + 1;
            q.offer(next);
        }
    }
}
```

### Remember

> **Unweighted shortest path → BFS**

For weighted graphs, consider Dijkstra or other shortest-path algorithms instead.

---

# 7. Pattern 5 — Multi-Source BFS

Very important pattern.

Instead of starting BFS from one node, start from **multiple nodes simultaneously**.

Examples:

- Rotten Oranges
- Distance to nearest `1`
- Walls and Gates
- Fire spreading
- Infection spreading

### Logic

Put **all starting sources** into the queue first.

```java
Queue<int[]> q = new LinkedList<>();

for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {

        if (grid[i][j] == SOURCE) {
            q.offer(new int[]{i, j});
        }
    }
}
```

Then run normal BFS.

### Key Idea

> **Multiple starting points → Multi-Source BFS**

---

# 8. Pattern 6 — Grid BFS

For matrix problems, use:

```text
up
down
left
right
```

Direction array:

```java
int[][] dirs = {
    {1, 0},
    {-1, 0},
    {0, 1},
    {0, -1}
};
```

Then:

```java
for (int[] d : dirs) {

    int nr = r + d[0];
    int nc = c + d[1];

    if (nr >= 0 && nr < n &&
        nc >= 0 && nc < m) {

        // process neighbor
    }
}
```

### Think BFS when:

```text
Grid + minimum steps
Grid + shortest path
Grid + spreading
Grid + levels
```

---

# 9. Pattern 7 — Rotting Oranges / Spreading Problems

Typical setup:

```text
Fresh → waiting
Rotten → source
```

Put all rotten cells into the queue.

Process one level at a time.

Each BFS level represents:

```text
1 minute
```

### Core Pattern

```java
int minutes = 0;

while (!q.isEmpty()) {

    int size = q.size();

    for (int i = 0; i < size; i++) {
        // process current cells
    }

    minutes++;
}
```

### Remember

> **BFS level = time unit**

---

# 10. Pattern 8 — Queue + Visited

Most graph/grid BFS problems need a visited structure.

Use:

```java
boolean[] visited;
```

for graphs.

Use:

```java
boolean[][] visited;
```

for grids.

Or modify the grid itself if allowed.

### Important

Usually mark a node **when you add it to the queue**, not when you remove it.

```java
visited[next] = true;
q.offer(next);
```

This prevents the same node from being added multiple times.

---

# 11. Pattern 9 — Sliding Window Maximum

One of the most important Queue/Deque problems.

Example:

```text
[1,3,-1,-3,5,3,6,7]
k = 3
```

Need the maximum in every window.

### Key Idea

Use a **monotonic decreasing deque**.

The deque stores indices.

Remove:

1. Indices outside the current window.
2. Smaller values from the back.

```java
Deque<Integer> dq = new ArrayDeque<>();

for (int i = 0; i < n; i++) {

    // Remove indices outside window
    while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
        dq.pollFirst();
    }

    // Remove smaller elements
    while (!dq.isEmpty() &&
           arr[dq.peekLast()] <= arr[i]) {
        dq.pollLast();
    }

    dq.offerLast(i);

    if (i >= k - 1) {
        ans[i - k + 1] = arr[dq.peekFirst()];
    }
}
```

### Remember

> **Sliding Window Maximum → Monotonic Deque**

---

# 12. Pattern 10 — Sliding Window Minimum

Same idea, but maintain an **increasing deque**.

Remove larger values:

```java
while (!dq.isEmpty() &&
       arr[dq.peekLast()] >= arr[i]) {
    dq.pollLast();
}
```

Then:

```text
front = minimum
```

---

# 13. Pattern 11 — Monotonic Deque

A deque can maintain candidates for a sliding window.

### Maximum

```text
Decreasing deque
Front = maximum
```

### Minimum

```text
Increasing deque
Front = minimum
```

### Important

Store **indices**, not just values, because you need to know when elements leave the window.

---

# 14. Pattern 12 — Circular Queue

A circular queue reuses array space.

Instead of moving all elements, use modulo:

```java
index = (index + 1) % capacity;
```

### Key Idea

When reaching the end:

```text
last index → first index
```

### Think

> Fixed-size queue + reuse empty positions → Circular Queue

---

# 15. Pattern 13 — Queue Using Two Stacks

Use:

```text
input stack
output stack
```

### Enqueue

Push into input.

### Dequeue

If output is empty:

```text
Move input → output
```

Then pop output.

```text
input:  1 2 3
              ↓
output: 3 2 1
```

The top of output becomes the oldest element.

### Key Idea

> Two stacks can reverse order and create FIFO behavior.

---

# 16. Pattern 14 — Stack Using Queues

For a stack using queues:

### Push

1. Add new element.
2. Move older elements behind it.

Now the newest element is at the front.

```text
Queue:
new → old elements
```

Then:

```text
pop = dequeue
```

---

# 17. Pattern 15 — First Non-Repeating Character

For a stream/string:

```text
a a b c
```

Find the first character that has appeared only once.

### Use

```text
HashMap + Queue
```

HashMap:

```text
character → frequency
```

Queue:

```text
candidate order
```

### Logic

For each character:

1. Add to frequency map.
2. Add character to queue.
3. Remove queue front while its frequency > 1.
4. Queue front is the answer.

```java
Map<Character, Integer> freq = new HashMap<>();
Queue<Character> q = new LinkedList<>();

for (char ch : stream.toCharArray()) {

    freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    q.offer(ch);

    while (!q.isEmpty() && freq.get(q.peek()) > 1) {
        q.poll();
    }

    char answer = q.isEmpty() ? '#' : q.peek();
}
```

### Pattern

> **Order + frequency → Queue + HashMap**

---

# 18. Pattern 16 — BFS Topological Sort

For a directed graph, use **Kahn's Algorithm**.

### Logic

Calculate indegree:

```text
indegree[node]
```

Put all nodes with:

```text
indegree = 0
```

into the queue.

Then:

1. Remove node.
2. Add it to result.
3. Reduce indegree of neighbors.
4. If neighbor becomes `0`, add it.

```java
Queue<Integer> q = new LinkedList<>();

for (int i = 0; i < n; i++) {
    if (indegree[i] == 0) {
        q.offer(i);
    }
}

while (!q.isEmpty()) {

    int node = q.poll();

    for (int next : graph[node]) {

        indegree[next]--;

        if (indegree[next] == 0) {
            q.offer(next);
        }
    }
}
```

### Important

> **Topological Sort using BFS → Kahn's Algorithm**

If processed node count `< n`, there is a cycle.

---

# 19. Pattern 17 — Task Scheduling

If tasks must be processed in order or according to prerequisites:

Think:

```text
Queue
+
Indegree
+
Topological Sort
```

Examples:

- Course Schedule
- Course Schedule II
- Task ordering
- Build dependencies
- Package installation dependencies

---

# 20. Pattern 18 — BFS State Problems

Sometimes the queue stores more than one value.

For example:

```java
Queue<int[]> q = new LinkedList<>();
```

Each item can store:

```text
row
column
distance
```

Example:

```java
q.offer(new int[]{r, c, distance});
```

Or:

```text
node
steps
```

### Think

> If BFS needs extra information about a state, store it in the queue.

---

# 21. Pattern 19 — BFS With State

Some problems require tracking:

```text
position
+
keys collected
```

or:

```text
position
+
remaining jumps
```

or:

```text
position
+
mask
```

Then the queue stores the complete state.

Example:

```java
Queue<int[]> q = new LinkedList<>();

q.offer(new int[]{row, col, mask});
```

### Important

Visited may also need multiple dimensions:

```text
visited[row][col][mask]
```

---

# 22. Pattern 20 — Priority Queue

A normal queue gives:

```text
FIFO
```

A priority queue gives:

```text
highest/lowest priority first
```

Java:

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

Default:

```text
Min Heap
```

Max heap:

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>(Collections.reverseOrder());
```

### Think Priority Queue when:

- Need minimum repeatedly
- Need maximum repeatedly
- Process highest priority first
- Top K problems
- Scheduling based on priority
- Dijkstra
- Merge K sorted lists

---

# 23. Pattern 21 — BFS vs DFS

### Use BFS when:

```text
Shortest path in unweighted graph
Minimum steps
Level order
Nearest distance
Spreading over time
```

### Use DFS when:

```text
Explore all possibilities
Backtracking
Connected components
Recursive structure
```

### Quick Rule

> **Shortest/minimum levels → BFS**

---

# 24. Queue Decision Tree

When you see a Queue problem:

### Question 1

Does it process elements in arrival order?

```text
YES → Queue
```

### Question 2

Is it level-by-level?

```text
YES → BFS
```

### Question 3

Does it ask for shortest distance in an unweighted graph/grid?

```text
YES → BFS
```

### Question 4

Are there multiple starting points?

```text
YES → Multi-Source BFS
```

### Question 5

Is it a sliding window min/max?

```text
YES → Monotonic Deque
```

### Question 6

Are there prerequisites/dependencies?

```text
YES → Topological Sort / Kahn's Algorithm
```

### Question 7

Do elements have priorities?

```text
YES → PriorityQueue
```

### Question 8

Does the queue need additional state?

```text
YES → Store arrays/objects in queue
```

---

# 25. Complexity

For normal BFS:

```text
Time:  O(V + E)
Space: O(V)
```

For grid BFS:

```text
Time:  O(rows * cols)
Space: O(rows * cols)
```

For sliding window maximum:

```text
Time:  O(n)
Space: O(k)
```

For Kahn's Topological Sort:

```text
Time:  O(V + E)
Space: O(V)
```

---

# 26. Queue Mistakes to Avoid

### Mistake 1

Using `remove()` when the queue may be empty.

Prefer:

```java
poll()
```

because it safely returns `null`.

### Mistake 2

Marking visited too late.

Prefer:

```java
visited[next] = true;
q.offer(next);
```

### Mistake 3

For level-order BFS, forgetting:

```java
int size = q.size();
```

### Mistake 4

Using a normal queue for sliding-window maximum.

Use:

```text
Deque
```

### Mistake 5

Using BFS for weighted shortest paths without checking edge weights.

---

# 27. Ultimate Queue Cheat Sheet

```text
FIFO Processing
    ↓
Queue

Level Order
    ↓
BFS + Queue

Shortest Path in Unweighted Graph
    ↓
BFS

Grid + Minimum Steps
    ↓
BFS

Multiple Starting Points
    ↓
Multi-Source BFS

Spreading / Infection / Fire
    ↓
Multi-Source BFS

Sliding Window Maximum
    ↓
Decreasing Monotonic Deque

Sliding Window Minimum
    ↓
Increasing Monotonic Deque

Dependencies / Prerequisites
    ↓
Kahn's Algorithm + Queue

Repeated Minimum/Maximum
    ↓
PriorityQueue

BFS With Extra Information
    ↓
Queue of States

First Non-Repeating Stream
    ↓
Queue + HashMap

Fixed-Size Queue
    ↓
Circular Queue
```

---

# 28. Most Important Queue Rule

When you see:

> **"Minimum steps / shortest path / nearest / level by level"**

Immediately think:

# BFS + QUEUE

When you see:

> **"Maximum or minimum inside every sliding window"**

Immediately think:

# MONOTONIC DEQUE

When you see:

> **"Prerequisites / dependencies / ordering"**

Think:

# KAHN'S ALGORITHM + QUEUE
