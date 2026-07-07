# Delete duplicate-value nodes from a sorted linked list

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

<sub>This challenge is part of a tutorial track by [MyCodeSchool](http://www.youtube.com/mycodeschool)</sub>


You are given the pointer to the head node of a sorted linked list, where the data in the nodes is in ascending order. Delete nodes and return a sorted list with each distinct value in the original list. The given head pointer may be null indicating that the list is empty.  

**Example**  

$head$ refers to the first node in the list $1 \rightarrow 2 \rightarrow 2 \rightarrow 3 \rightarrow 3 \rightarrow 3 \rightarrow 3 \rightarrow NULL$.  

Remove 1 of the $2$ data values and return $head$ pointing to the revised list $1 \rightarrow 2 \rightarrow 3 \rightarrow NULL$.  

**Function Description**  

Complete the *removeDuplicates* function in the editor below.  

*removeDuplicates* has the following parameter:  

- *SinglyLinkedListNode pointer head:* a reference to the head of the list  

**Returns**  

- *SinglyLinkedListNode pointer:* a reference to the head of the revised list  

**Input Format**

The first line contains an integer $t$, the number of test cases.


The format for each test case is as follows:  

The first line contains an integer $n$, the number of elements in the linked list.  
Each of the next $n$ lines contains an integer, the $data$ value for each of the elements of the linked list.

**Constraints**

- $ 1 \le t \le 10$  
- $ 1 \le n \le 1000$
- $ 1 \le list[i] \le 1000$


**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-07T20:46:16.472Z  

```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result {

    /*
     * Complete the 'removeDuplicates' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
    if (head == null) {
        return null;
    }

    SinglyLinkedListNode current = head;

    while (current.next != null) {
        if (current.data == current.next.data) {
            // Remove duplicate node
            current.next = current.next.next;
        } else {
            // Move ahead only when values are different
            current = current.next;
        }
    }

    return head;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                SinglyLinkedList llist = new SinglyLinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                SinglyLinkedListNode llist1 = Result.removeDuplicates(llist.head);

                SinglyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem)