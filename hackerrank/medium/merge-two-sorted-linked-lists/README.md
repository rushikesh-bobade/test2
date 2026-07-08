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

**Language:** Go  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T14:48:38.157Z  

```go
package main

import (
    "bufio"
    "fmt"
    "os"
)

type SinglyLinkedListNode struct {
    data int32
    next *SinglyLinkedListNode
}

type SinglyLinkedList struct {
    head *SinglyLinkedListNode
    tail *SinglyLinkedListNode
}

func (list *SinglyLinkedList) insertNode(data int32) {
    node := &SinglyLinkedListNode{data: data}

    if list.head == nil {
        list.head = node
    } else {
        list.tail.next = node
    }

    list.tail = node
}

func mergeLists(head1 *SinglyLinkedListNode, head2 *SinglyLinkedListNode) *SinglyLinkedListNode {
    dummy := &SinglyLinkedListNode{}
    current := dummy

    for head1 != nil && head2 != nil {
        if head1.data <= head2.data {
            current.next = head1
            head1 = head1.next
        } else {
            current.next = head2
            head2 = head2.next
        }
        current = current.next
    }

    if head1 != nil {
        current.next = head1
    } else {
        current.next = head2
    }

    return dummy.next
}

func printList(node *SinglyLinkedListNode, writer *bufio.Writer) {
    for node != nil {
        fmt.Fprint(writer, node.data)
        if node.next != nil {
            fmt.Fprint(writer, " ")
        }
        node = node.next
    }
    fmt.Fprintln(writer)
}

func main() {
    reader := bufio.NewReader(os.Stdin)
    writer := bufio.NewWriter(os.Stdout)
    defer writer.Flush()

    var t int
    fmt.Fscan(reader, &t)

    for ; t > 0; t-- {
        var n int
        fmt.Fscan(reader, &n)

        list1 := SinglyLinkedList{}
        for i := 0; i < n; i++ {
            var x int32
            fmt.Fscan(reader, &x)
            list1.insertNode(x)
        }

        fmt.Fscan(reader, &n)

        list2 := SinglyLinkedList{}
        for i := 0; i < n; i++ {
            var x int32
            fmt.Fscan(reader, &x)
            list2.insertNode(x)
        }

        result := mergeLists(list1.head, list2.head)
        printList(result, writer)
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem)