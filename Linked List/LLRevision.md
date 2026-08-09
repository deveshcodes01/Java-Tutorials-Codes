# Linked List Revision Roadmap for DSA Interviews

Master these core patterns instead of memorizing every question.

------------------------------------------------------------------------

# 1. Basics (Must Know)

Understand:

-   What is a Linked List?
-   Node structure
-   Head and Tail
-   `next` pointer
-   Traversing a linked list

Practice: - Print linked list - Count nodes - Search element

------------------------------------------------------------------------

# 2. Insertion

Learn to insert:

-   At beginning
-   At end
-   At any position
-   Before a node
-   After a node

Practice: - Insert in middle - Insert at position K

------------------------------------------------------------------------

# 3. Deletion

Practice deleting:

-   First node
-   Last node
-   Any position
-   Delete given key
-   Delete duplicates

------------------------------------------------------------------------

# 4. Reversing ⭐⭐⭐⭐⭐

Learn:

-   Reverse entire linked list
-   Reverse first K nodes
-   Reverse in groups of K
-   Reverse between positions L and R

Practice:

-   Reverse Linked List
-   Reverse Nodes in K Group
-   Reverse Linked List II

------------------------------------------------------------------------

# 5. Fast & Slow Pointer ⭐⭐⭐⭐⭐

Pattern:

``` java
slow = slow.next;
fast = fast.next.next;
```

Practice:

-   Middle of Linked List
-   Detect Cycle
-   Starting point of cycle
-   Happy Number
-   Palindrome Linked List
-   Remove Nth Node From End

------------------------------------------------------------------------

# 6. Two Pointer Pattern

Practice:

-   Remove Nth Node From End
-   Merge Two Sorted Lists
-   Partition List
-   Rotate List

------------------------------------------------------------------------

# 7. Cycle Detection

Learn:

-   Floyd's Cycle Detection
-   Detect cycle
-   Find starting node
-   Length of cycle

Practice:

-   Linked List Cycle
-   Linked List Cycle II

------------------------------------------------------------------------

# 8. Merging Pattern

Practice:

-   Merge Two Sorted Lists
-   Merge K Sorted Lists
-   Intersection of Two Linked Lists

------------------------------------------------------------------------

# 9. Dummy Node Pattern ⭐⭐⭐⭐

``` java
Node dummy = new Node(0);
dummy.next = head;
```

Practice:

-   Remove Duplicates
-   Merge Lists
-   Swap Nodes in Pairs
-   Partition List

------------------------------------------------------------------------

# 10. Palindrome Pattern

Steps:

1.  Find middle
2.  Reverse second half
3.  Compare both halves
4.  Restore (optional)

Practice:

-   Palindrome Linked List

------------------------------------------------------------------------

# 11. Sorting Linked List

Learn:

-   Merge Sort on Linked List
-   Why Quick Sort is not preferred

Practice:

-   Sort List

------------------------------------------------------------------------

# 12. Rearrangement Pattern

Practice:

-   Odd Even Linked List
-   Reorder List
-   Rotate List

------------------------------------------------------------------------

# 13. Clone Linked List

Practice:

-   Copy List with Random Pointer

Approaches:

-   HashMap
-   O(1) Space

------------------------------------------------------------------------

# 14. Pointer Manipulation

``` java
prev.next = curr.next;
curr.next = prev;
next = curr.next;
curr = next;
```

Important pointers:

-   `head`
-   `tail`
-   `curr`
-   `prev`
-   `next`
-   `slow`
-   `fast`
-   `dummy`

------------------------------------------------------------------------

# Essential Algorithms

-   Traversal
-   Reverse
-   Middle Node
-   Detect Cycle
-   Merge Lists
-   Delete Node
-   Insert Node
-   Find Length
-   Remove Nth Node
-   Reverse K Nodes
-   Sort List
-   Clone List
-   Intersection

------------------------------------------------------------------------

# Top Interview Questions

## Easy

-   Reverse Linked List
-   Middle of Linked List
-   Search in Linked List
-   Delete Node
-   Remove Duplicates
-   Merge Two Sorted Lists

## Medium

-   Remove Nth Node From End
-   Detect Cycle
-   Linked List Cycle II
-   Palindrome Linked List
-   Odd Even Linked List
-   Intersection of Two Linked Lists
-   Rotate List
-   Reorder List
-   Reverse Between
-   Reverse K Group
-   Swap Nodes in Pairs

## Hard

-   Merge K Sorted Lists
-   Copy List with Random Pointer
-   Sort List

------------------------------------------------------------------------

# 2--3 Hour Revision Plan

  Time     Topic
  -------- ----------------------
  10 min   Basics
  20 min   Insertion & Deletion
  25 min   Reverse Linked List
  30 min   Fast & Slow Pointer
  20 min   Dummy Node Pattern
  20 min   Merge Pattern
  20 min   Cycle Detection
  15 min   Palindrome
  25 min   Reverse K Group
  20 min   Clone & Sort

------------------------------------------------------------------------

# Golden Rules

Before writing code, always ask:

-   Which pointers am I using?
-   Do I need a dummy node?
-   Am I changing links instead of node values?
-   Will I lose the remaining list if I modify `next`?
-   Have I handled empty and single-node edge cases?

------------------------------------------------------------------------

## Goal

Master these patterns and you'll be able to solve **80--90% of Linked
List interview problems** across LeetCode, GeeksforGeeks, Coding Ninjas,
and other interview platforms.
