# Insert a Node at the Tail of a Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

<sub>This challenge is part of a tutorial track by [MyCodeSchool](http://www.youtube.com/mycodeschool) and is accompanied by a video lesson.</sub>

You are given the pointer to the head node of a linked list and an integer to add to the list. Create a new node with the given integer. Insert this node at the tail of the linked list and return the head node of the linked list formed after inserting this new node. The given head pointer may be null, meaning that the initial list is empty.  

**Function Description**   

Complete the $insertNodeAtTail$ function with the following parameters:  

- $SinglyLinkedListNode\ pointer\ head$: a reference to the head of a list   
- $int\ data$: the data value for the node to insert  

**Returns**   

- $SinglyLinkedListNode\ pointer$: reference to the head of the modified linked list  


**Input Format**

The first line contains an integer $n$, the number of elements in the linked list.  
The next $n$ lines contain an integer each, the value that needs to be inserted at tail.  


**Constraints**

- $1 \le n \le 1000$  
- $1 \le list_i \le 1000$  


**Output Format**

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-07T21:38:53.403Z  

```js


// Complete the insertNodeAtTail function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
function insertNodeAtTail(head, data) {
    const newNode = new SinglyLinkedListNode(data);

    // If linked list is empty
    if (head === null) {
        return newNode;
    }

    // Traverse to the last node
    let current = head;

    while (current.next !== null) {
        current = current.next;
    }

    // Insert new node at tail
    current.next = newNode;

    return head;
}


```

---

[View on HackerRank](https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem)