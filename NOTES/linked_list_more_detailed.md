# Linked Lists — Expanded Notes

## Detailed Concepts

### Memory layout
- Nodes are allocated on the heap (in Java by `new`, in C by `malloc`).
- Each node contains payload and pointer(s) to neighbors.
- The list itself is usually maintained by a `head` pointer; optionally a `tail` pointer.

### Pointer invariants
- After any insert/delete operation, ensure pointers leading into and out of the changed nodes are updated before discarding references.
- For doubly linked lists, update `prev` and `next` consistently to avoid dangling backwards links.

### Edge cases to always handle
- empty list (head == null)
- single node (head.next == null)
- inserting before head or after tail
- deleting the head or tail

---

## Deeper Operation Explanations

Insert at position `k` (0-indexed):
1. If `k == 0`, insert at head.
2. Else, traverse to node at index `k-1` (stop early if null to avoid overflow).
3. Create new node, set `new.next = prev.next`, `prev.next = new`.

Delete at position `k`:
1. If `k == 0`, head = head.next.
2. Else, traverse to `k-1` and adjust `prev.next = prev.next.next` (handle nulls).

Merge two sorted singly-linked lists (iterative):
1. Use a dummy node `dummy` and `tail = dummy`.
2. While both lists non-empty compare head values, attach smaller node to `tail.next` and advance.
3. Attach remaining nodes, return `dummy.next`.

Add two numbers represented by linked lists (digits stored in reverse order):
1. Traverse both lists simultaneously with carry.
2. Sum = (a? a->val:0) + (b? b->val:0) + carry.
3. Create new node with `sum%10`, update carry = `sum/10`.
4. Continue until both lists and carry are exhausted.

---

## Algorithms & Complexity Notes

- Reversing list: O(n) time, O(1) space (iterative three-pointer approach).
- Detecting cycle (Floyd): O(n) time, O(1) space. After detection, to find cycle start reset one pointer to head and advance both one step until equal.
- Merging sorted lists: O(n) time, O(1) extra space (relink nodes).

---

## Testing Checklist

- Test empty list operations
- Test single-element list operations
- Test insertion at head, middle, tail
- Test deletion at head, middle, tail
- Test reverse on lists of length 0,1,2,>2
- Test cycle detection on lists with and without cycles
- Test merged list correctness on various size inputs

---

## Idiomatic Patterns

- Use a dummy / sentinel node to simplify head/tail manipulations.
- Maintain `tail` pointer when you frequently append to support O(1) tail insertion.
- For Java, prefer `null` checks and encapsulate node structure as private nested class.
- For C, carefully free removed nodes to avoid memory leaks and use `valgrind` to check memory issues.

---

## References & Further Exercises

- Implement iterator for doubly linked list.
- Implement `removeNthFromEnd` (two-pointer technique).
- Implement copy of list with `random` pointer.
- Implement in-place list partitioning around a value.
