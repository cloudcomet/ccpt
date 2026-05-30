## Stacks

### 1. Overview
A stack is an abstract data type (ADT) that stores elements in Last-In-First-Out (LIFO) order: the most recently pushed element is the first one popped. Stacks model nested behaviour (call stacks, nested expressions) and are simple but powerful building blocks for many algorithms.

### 2. Core operations (formal)
- push(x): insert element x at the top.
- pop(): remove and return the top element; error if empty.
- peek()/top(): return top element without removing; error if empty.
- isEmpty(): boolean test for emptiness.
- size(): number of elements currently in the stack.

All core operations run in $O(1)$ time for standard implementations.

### 3. Implementations
- Array-backed (dynamic array / vector): store elements in contiguous memory; track `topIndex`. Easy and cache-friendly; may require resizing (amortized $O(1)$ push).
- Singly-linked list: head represents the top; push/pop update head pointer in $O(1)$. No resizing; uses extra pointers per element.
- Two-stack patterns: implement other ADTs (e.g., queue) using two stacks.

Java example (array-backed, simplified):
```java
public class ArrayStack<E> {
    private E[] data;
    private int top = 0; // points to next free slot

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) { data = (E[]) new Object[capacity]; }

    public void push(E x) {
        if (top == data.length) resize();
        data[top++] = x;
    }

    public E pop() {
        if (top == 0) throw new RuntimeException("Empty stack");
        E val = data[--top];
        data[top] = null; // avoid memory leak
        return val;
    }

    public E peek() { if (top == 0) throw new RuntimeException("Empty"); return data[top-1]; }
    public boolean isEmpty() { return top == 0; }
}
```

### 4. Complexity
- Time: `push`, `pop`, `peek`, `isEmpty` — $O(1)$ (amortized $O(1)$ for dynamic arrays).
- Space: $O(n)$ to store n elements.

### 5. Common algorithms & use-cases
- Expression evaluation and parsing: convert infix to postfix (Shunting-yard) then evaluate with a stack.
- Depth-first search (explicit stack instead of recursion) and backtracking (undo operations).
- Call stack semantics: function calls and returns.

Example: evaluate postfix `3 4 + 2 *` — push 3, push 4, pop 4 & 3 apply `+` push 7, push 2, pop 2 & 7 apply `*` → result 14.

### 6. Patterns & interview problems
- Next greater element, balanced parentheses, evaluate expressions, stock span problem, reverse stack using recursion.

### 7. Diagrams
```mermaid
flowchart TB
    direction TB
    subgraph stk [Stack (top at bottom of diagram for clarity)]
        A[1]
        B[3]
        C[7]
        D[Top: 9]
    end
    A --> B --> C --> D
```

### 8. Notes and pitfalls
- Array-backed stacks must handle resizing or overflow checks.
- Linked-list stacks cost more memory per element (pointer overhead) but avoid copying/resizing.
- Avoid exposing internal array to callers; encapsulate properly.
