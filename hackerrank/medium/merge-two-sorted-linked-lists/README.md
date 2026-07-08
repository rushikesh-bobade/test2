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

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T14:49:20.731Z  

```java
import java.io.*;
import java.util.*;

public class Solution {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static SinglyLinkedListNode mergeLists(
            SinglyLinkedListNode head1,
            SinglyLinkedListNode head2) {

        SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tail = dummy;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }

        if (head1 != null)
            tail.next = head1;
        else
            tail.next = head2;

        return dummy.next;
    }

    static SinglyLinkedListNode insert(
            SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if (head == null)
            return node;

        SinglyLinkedListNode temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = node;

        return head;
    }

    static void printList(SinglyLinkedListNode head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            SinglyLinkedListNode head1 = null;

            for (int i = 0; i < n; i++) {
                head1 = insert(head1,
                        Integer.parseInt(br.readLine()));
            }

            int m = Integer.parseInt(br.readLine());
            SinglyLinkedListNode head2 = null;

            for (int i = 0; i < m; i++) {
                head2 = insert(head2,
                        Integer.parseInt(br.readLine()));
            }

            SinglyLinkedListNode result = mergeLists(head1, head2);

            printList(result);
            System.out.println();
        }
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem)