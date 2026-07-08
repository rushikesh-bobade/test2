# Merge two sorted linked lists

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

<sub>This challenge is part of a tutorial track by [MyCodeSchool](http://www.youtube.com/mycodeschool)</sub>

Given pointers to the heads of two sorted linked lists, merge them into a single, sorted linked list. Either head pointer may be null meaning that the corresponding list is empty.

**Example**  
$headA$ refers to $1 \rightarrow 3 \rightarrow 7 \rightarrow NULL$  
$headB$ refers to $1 \rightarrow 2 \rightarrow NULL$  

The new list is $1 \rightarrow 1 \rightarrow 2 \rightarrow 3 \rightarrow 7 \rightarrow NULL$  

**Function Description**  

Complete the *mergeLists* function in the editor below.  

*mergeLists* has the following parameters:  

- *SinglyLinkedListNode pointer headA:* a reference to the head of a list  
- *SinglyLinkedListNode pointer headB:* a reference to the head of a list  

**Returns**  

- *SinglyLinkedListNode pointer:* a reference to the head of the merged list  


**Input Format**

The first line contains an integer $t$, the number of test cases.  

The format for each test case is as follows:  

The first line contains an integer $n$, the length of the first linked list.  
The next $n$ lines contain an integer each, the elements of the linked list.  
The next line contains an integer $m$, the length of the second linked list.  
The next $m$ lines contain an integer each, the elements of the second linked list.  

**Constraints**

- $1 \le t \le 10$  
- $1 \le n, m \le 1000$
- $1 \le list[i] \le 1000$, where $list[i]$ is the $i^{th}$ element of the list.

**Output Format**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T14:47:58.569Z  

```cpp
#include <bits/stdc++.h>
using namespace std;

class SinglyLinkedListNode {
public:
    int data;
    SinglyLinkedListNode* next;

    SinglyLinkedListNode(int node_data) {
        data = node_data;
        next = nullptr;
    }
};

class SinglyLinkedList {
public:
    SinglyLinkedListNode* head;
    SinglyLinkedListNode* tail;

    SinglyLinkedList() {
        head = nullptr;
        tail = nullptr;
    }

    void insert_node(int node_data) {
        SinglyLinkedListNode* node = new SinglyLinkedListNode(node_data);

        if (!head) {
            head = node;
        } else {
            tail->next = node;
        }

        tail = node;
    }
};

SinglyLinkedListNode* mergeLists(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2) {
    SinglyLinkedListNode* dummy = new SinglyLinkedListNode(0);
    SinglyLinkedListNode* curr = dummy;

    while (head1 && head2) {
        if (head1->data <= head2->data) {
            curr->next = head1;
            head1 = head1->next;
        } else {
            curr->next = head2;
            head2 = head2->next;
        }
        curr = curr->next;
    }

    if (head1)
        curr->next = head1;
    else
        curr->next = head2;

    return dummy->next;
}

void printList(SinglyLinkedListNode* node) {
    while (node) {
        cout << node->data;
        if (node->next)
            cout << " ";
        node = node->next;
    }
}

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        SinglyLinkedList list1;
        for (int i = 0; i < n; i++) {
            int x;
            cin >> x;
            list1.insert_node(x);
        }

        cin >> n;

        SinglyLinkedList list2;
        for (int i = 0; i < n; i++) {
            int x;
            cin >> x;
            list2.insert_node(x);
        }

        SinglyLinkedListNode* result = mergeLists(list1.head, list2.head);

        printList(result);
        cout << "\n";
    }

    return 0;
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem)