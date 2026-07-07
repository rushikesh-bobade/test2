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

**Language:** TypeScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-07T20:51:38.653Z  

```ts
'use strict';

import { WriteStream, createWriteStream } from "fs";
process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString: string = '';
let inputLines: string[] = [];
let currentLine: number = 0;

process.stdin.on('data', function(inputStdin: string): void {
    inputString += inputStdin;
});

process.stdin.on('end', function(): void {
    inputLines = inputString.split('\n');
    inputString = '';

    main();
});

function readLine(): string {
    return inputLines[currentLine++];
}

class SinglyLinkedListNode {
    data: number;
    next: SinglyLinkedListNode | null;

    constructor(nodeData: number) {
        this.data = nodeData;
        this.next = null;
    }
};

class SinglyLinkedList {
    head: SinglyLinkedListNode | null;
    tail: SinglyLinkedListNode | null;

    constructor() {
        this.head = null;
        this.tail = null;
    }

    insertNode(nodeData: number): void {
        const node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail!.next = node;
        }

        this.tail = node;
    }
};

function printSinglyLinkedList(node: SinglyLinkedListNode | null, sep: string, ws: WriteStream): void {
    while (node != null) {
        ws.write(String(node.data));

        node = node.next;

        if (node != null) {
            ws.write(sep);
        }
    }
}

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
 *     number data;
 *     SinglyLinkedListNode next;
 * }
 *
 */

function removeDuplicates(llist: SinglyLinkedListNode): SinglyLinkedListNode {
    if (llist == null) {
        return llist;
    }

    let current: SinglyLinkedListNode | null = llist;

    while (current != null && current.next != null) {
        if (current.data === current.next.data) {
            // Remove duplicate node
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }

    return llist;
}
function main() {
    const ws: WriteStream = createWriteStream(process.env['OUTPUT_PATH']);

    const t: number = parseInt(readLine().trim(), 10);

    for (let tItr: number = 0; tItr < t; tItr++) {
        let llist: SinglyLinkedList = new SinglyLinkedList();

        const llistCount: number = parseInt(readLine().trim(), 10);

        for (let i: number = 0; i < llistCount; i++) {
            const llistItem: number = parseInt(readLine().trim(), 10);

            llist.insertNode(llistItem);
        }

        const llist1: SinglyLinkedListNode = removeDuplicates(llist.head);

        printSinglyLinkedList(llist1, ' ', ws);
        ws.write('\n');
    }

    ws.end();
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem)