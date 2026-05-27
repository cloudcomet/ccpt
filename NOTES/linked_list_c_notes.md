# Linked Lists in C — Notes & Examples

## 1. Node Structure (C)

```c
typedef struct Node {
    int data;
    struct Node *next;
} Node;

Node* new_node(int v){
    Node* n = (Node*)malloc(sizeof(Node));
    if(!n) exit(1); // handle allocation failure
    n->data = v; n->next = NULL; return n;
}
```

Remember to `#include <stdlib.h>` and `#include <stdio.h>`.

---

## 2. Basic Operations

Insert at head:

```c
void insert_head(Node** head_ref, int val){
    Node* n = new_node(val);
    n->next = *head_ref;
    *head_ref = n;
}
```

Insert at tail (O(n)):

```c
void insert_tail(Node** head_ref, int val){
    Node* n = new_node(val);
    if(*head_ref == NULL){ *head_ref = n; return; }
    Node* cur = *head_ref;
    while(cur->next) cur = cur->next;
    cur->next = n;
}
```

Delete by value:

```c
void delete_value(Node** head_ref, int val){
    if(*head_ref == NULL) return;
    Node* cur = *head_ref;
    if(cur->data == val){ *head_ref = cur->next; free(cur); return; }
    while(cur->next && cur->next->data != val) cur = cur->next;
    if(cur->next){ Node* tmp = cur->next; cur->next = tmp->next; free(tmp); }
}
```

Reverse (iterative):

```c
void reverse(Node** head_ref){
    Node *prev = NULL, *cur = *head_ref, *next = NULL;
    while(cur){ next = cur->next; cur->next = prev; prev = cur; cur = next; }
    *head_ref = prev;
}
```

---

## 3. Cycle Detection (Floyd)

```c
int has_cycle(Node* head){
    Node *slow=head, *fast=head;
    while(fast && fast->next){ slow = slow->next; fast = fast->next->next; if(slow==fast) return 1; }
    return 0;
}
```

To find cycle start (after detection): move one pointer to head and advance both by one until equal.

---

## 4. Merge Two Sorted Lists (Iterative)

```c
Node* merge_sorted(Node* a, Node* b){
    Node dummy; Node* tail = &dummy; dummy.next = NULL;
    while(a && b){ if(a->data <= b->data){ tail->next = a; a = a->next; } else { tail->next = b; b = b->next; } tail = tail->next; }
    tail->next = (a ? a : b);
    return dummy.next;
}
```

---

## 5. Add Two Numbers (Lists as digits reversed)

```c
Node* add_lists(Node* a, Node* b){
    Node dummy; Node* tail=&dummy; dummy.next=NULL; int carry=0;
    while(a || b || carry){
        int s = carry + (a? a->data : 0) + (b? b->data : 0);
        carry = s/10;
        tail->next = new_node(s%10); tail = tail->next;
        if(a) a=a->next; if(b) b=b->next;
    }
    return dummy.next;
}
```

---

## 6. Memory & Debugging Tips

- Always `free()` removed nodes to avoid memory leaks.
- Use `valgrind --leak-check=full ./a.out` to detect leaks and invalid access.
- Check for `NULL` pointers before dereferencing.

---

## 7. Compile & Run Example

Save a small test driver (e.g., `list_test.c`) that uses the above functions. Compile:

```bash
gcc -std=c11 -Wall -Wextra -o list_test list_test.c
./list_test
```

---

## 8. Exercises (C)

- implement `removeNthFromEnd` using two pointers
- implement `isPalindrome` for linked list (reverse half)
- implement `copyRandomList` using hashing or interleaving
