# Reverse a doubly linked list

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

<sub>This challenge is part of a tutorial track by [MyCodeSchool](http://www.youtube.com/mycodeschool)</sub>


Given the pointer to the head node of a doubly linked list, reverse the order of the nodes in place. That is, change the *next* and *prev* pointers of the nodes so that the direction of the list is reversed. Return a reference to the head node of the reversed list. 

**Note:** The head node might be NULL to indicate that the list is empty.  

**Function Description**

Complete the _reverse_ function in the editor below.  

reverse has the following parameter(s):

- *DoublyLinkedListNode head*: a reference to the head of a DoublyLinkedList  

Returns  
- *DoublyLinkedListNode*: a reference to the head of the reversed list  

**Input Format**

The first line contains an integer $t$, the number of test cases.  

Each test case is of the following format:

-  The first line contains an integer $n$, the number of elements in the linked list.  
-  The next $n$ lines contain an integer each denoting an element of the linked list.

**Constraints**

- $1 \le t \le 10$  
- $0 \le n \le 1000$  
- $0 \le DoublyLinkedListNode.data \le 1000$   

**Output Format**

Return a reference to the head of your reversed list.  The provided code will print the reverse array as a one line of space-separated integers for each test case.

## Solution

**Language:** TypeScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T13:59:20.556Z  

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

class DoublyLinkedListNode {
    data: number;
    next: DoublyLinkedListNode | null;
    prev: DoublyLinkedListNode | null;

    constructor(nodeData: number) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
};

class DoublyLinkedList {
    head: DoublyLinkedListNode | null;
    tail: DoublyLinkedListNode | null;

    constructor() {
        this.head = null;
        this.tail = null;
    }

    insertNode(nodeData: number): void {
        let node = new DoublyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail!.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
};

function printDoublyLinkedList(node: DoublyLinkedListNode | null, sep: string, ws: WriteStream): void {
    while (node != null) {
        ws.write(String(node.data));

        node = node.next;

        if (node != null) {
            ws.write(sep);
        }
    }
}

/*
 * Complete the 'reverse' function below.
 *
 * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
 * The function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
 */

/*
 * For your reference:
 *
 * DoublyLinkedListNode {
 *     number data;
 *     DoublyLinkedListNode next;
 *     DoublyLinkedListNode prev;
 * }
 *
 */

function reverse(llist: DoublyLinkedListNode): DoublyLinkedListNode {
    let current: DoublyLinkedListNode | null = llist;
    let temp: DoublyLinkedListNode | null = null;

    while (current !== null) {
        // Swap prev and next
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;

        // Move to the next node in the original list
        current = current.prev;
    }

    // temp points to the previous node of the new head
    if (temp !== null) {
        return temp.prev!;
    }

    return llist;
}

function main() {
    const ws: WriteStream = createWriteStream(process.env['OUTPUT_PATH']);

    const t: number = parseInt(readLine().trim(), 10);

    for (let tItr: number = 0; tItr < t; tItr++) {
        let llist: DoublyLinkedList = new DoublyLinkedList();

        const llistCount: number = parseInt(readLine().trim(), 10);

        for (let i: number = 0; i < llistCount; i++) {
            const llistItem: number = parseInt(readLine().trim(), 10);

            llist.insertNode(llistItem);
        }

        const llist1: DoublyLinkedListNode = reverse(llist.head);

        printDoublyLinkedList(llist1, ' ', ws);
        ws.write('\n');
    }

    ws.end();
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem)