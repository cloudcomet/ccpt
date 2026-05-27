# Detailed Notes: Linked Lists

## 1. Overview

A linked list is a linear data structure where each element (node) contains data and a reference (pointer) to the next node. Unlike arrays, linked lists store elements non-contiguously and allow efficient insertions and deletions at arbitrary positions.

Key properties:
- Dynamic size (no need to pre-allocate)
- Efficient insertion/deletion at head or middle (O(1) if node reference is known)
- Sequential access (no random access by index)

---

## 2. Types of Linked Lists

- **Singly linked list**: each node points to the next node.
- **Doubly linked list**: nodes have `next` and `prev` pointers.
- **Circular linked list**: last node points back to the head (applies to both singly and doubly).

ASCII diagrams:

Singly (head -> ... -> null):

```
head
  v
 [A] -> [B] -> [C] -> null
```

Doubly:

```
null <- [A] <-> [B] <-> [C] -> null
```

Circular singly:

```
     +------------------+
     |                  |
 [A] -> [B] -> [C] ------
```

---

## 3. Node Structure (Java)

```java
class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}
```

For doubly linked list:

```java
class DNode {
    int data;
    DNode next, prev;
    DNode(int d) { data = d; next = prev = null; }
}
```

---

## 4. Common Operations (Singly)

Assume `head` is reference to first node.

- **Traversal**: visit nodes one by one starting from `head`.
- **Insert at head**: create new node, set its `next` to current head, update `head`.
- **Insert at tail**: traverse to last node, set last.next = newNode.
- **Insert at position**: traverse to node before position, adjust pointers.
- **Delete head**: head = head.next.
- **Delete tail**: traverse to second-last, set its next = null.
- **Delete at position**: adjust pointers of surrounding nodes.
- **Search**: traverse and compare data.
- **Reverse list**: iterative (3-pointer) or recursive.

### Time complexities

- Access by index: O(n)
- Search: O(n)
- Insert at head: O(1)
- Insert at tail: O(n) (O(1) if tail pointer maintained)
- Delete (given node or index): O(1) if node reference and prev known, otherwise O(n)

---

## 5. Java Examples

Singly linked list with basic operations:

```java
public class SinglyLinkedList {
    private static class Node { int data; Node next; Node(int d){data=d;} }
    private Node head;

    public void insertHead(int val){
        Node n = new Node(val);
        n.next = head;
        head = n;
    }

    public void insertTail(int val){
        Node n = new Node(val);
        if(head==null){ head = n; return; }
        Node cur = head;
        while(cur.next!=null) cur = cur.next;
        cur.next = n;
    }

    public boolean search(int val){
        Node cur = head;
        while(cur!=null){ if(cur.data==val) return true; cur = cur.next; }
        return false;
    }

    public void deleteHead(){ if(head!=null) head = head.next; }

    public void deleteValue(int val){
        if(head==null) return;
        if(head.data==val){ head = head.next; return; }
        Node cur = head;
        while(cur.next!=null && cur.next.data!=val) cur = cur.next;
        if(cur.next!=null) cur.next = cur.next.next;
    }

    public void printList(){
        Node cur = head;
        while(cur!=null){ System.out.print(cur.data + " -> "); cur = cur.next; }
        System.out.println("null");
    }

    // reverse iterative
    public void reverse(){
        Node prev = null, cur = head;
        while(cur!=null){ Node next = cur.next; cur.next = prev; prev = cur; cur = next; }
        head = prev;
    }
}
```

Usage example:
```java
SinglyLinkedList list = new SinglyLinkedList();
list.insertHead(3); list.insertHead(2); list.insertTail(4);
list.printList(); // 2 -> 3 -> 4 -> null
list.deleteValue(3); list.printList(); // 2 -> 4 -> null
list.reverse(); list.printList(); // 4 -> 2 -> null
```

---

## 6. Reverse — Explanation & Diagram

Iterative reverse uses three pointers: `prev`, `cur`, `next`.

Initial:

```
prev=null, cur=[A]->[B]->[C]->null
```

Step 1:

```
next=[B]
cur.next=prev -> [A]->null
prev=[A]
cur=next -> [B]
```

Repeat until `cur==null`, set `head=prev`.

---

## 7. Doubly Linked List Notes

- Each node has `prev` and `next` pointers.
- Insertions and deletions at known nodes are O(1) because both neighbors are reachable.
- More memory per node (extra pointer).

Java skeleton:
```java
class DNode { int data; DNode next, prev; DNode(int d){data=d;} }

class DoublyLinkedList {
    DNode head, tail;
    void insertTail(int v){ DNode n=new DNode(v); if(tail==null){head=tail=n;} else{tail.next=n; n.prev=tail; tail=n;} }
    // similar delete and insert methods
}
```

---

## 8. Circular Lists

- Circular lists have no `null` terminator; traversal must check for cycle stop at head.
- Useful for round-robin scheduling and cyclic buffers.

Circular singly insert tail (diagram):

```
head -> [A] -> [B] -> [C]
                ^         |
                +---------+
```

---

## 9. Advanced Topics

- **Detect cycle**: Floyd’s Tortoise and Hare (slow/fast pointers). O(n) time, O(1) space.
- **Find cycle start**: after detection, reset one pointer to head and move both at same speed.
- **Merge two sorted lists**: standard pointer merging algorithm.
- **Add two numbers represented by lists**: digit-wise addition with carry.
- **Copy list with random pointer**: more advanced problem with hashing or interleaving technique.

Floyd's cycle detection sketch:
```text
slow = slow.next
fast = fast.next.next
if slow == fast -> cycle exists
```

---

## 10. When to Use Linked Lists

- when frequent insertions/deletions at front or middle are required
- when you need a simple dynamic container
- when memory reallocation cost for arrays is prohibitive

When NOT to use:
- when frequent random access by index is required (use array or ArrayList)
- when memory overhead per element must be minimal

---

## 11. Common Pitfalls

- forgetting to update `next`/`prev` correctly (leaks or broken lists)
- failing to handle empty list or single-node edge cases
- not freeing or nulling references (in other languages) — in Java GC helps but logical leaks still possible
- off-by-one in insertion/deletion at positions

---

## 12. Complexity Summary

- Traversal / Search: O(n)
- Insert at head: O(1)
- Insert at tail: O(n) (O(1) with tail pointer)
- Delete head: O(1)
- Delete value (search + delete): O(n)

---

## 13. Short Cheatsheet

- Use singly linked list for simple stacks & queues (with tail pointer for O(1) enqueue).
- Use doubly linked list for efficient removal from both ends and list iterators.
- Use circular lists for round-robin and cyclic structures.

---

If you want, I can:
- add ready-to-run Java files under `java_dsa/270526` with unit tests
- include diagrams in PNG (requires image files)
- create a short revision sheet for interviews
