# Print in Reverse

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

<sub>This challenge is part of a tutorial track by [MyCodeSchool](http://www.youtube.com/mycodeschool) and is accompanied by a video lesson.</sub>

Given a pointer to the head of a singly-linked list, print each $data$ value from the reversed list.  If the given list is empty, do not print anything.

**Example**  

$head*$ refers to the linked list with $data$ values $1 \rightarrow 2 \rightarrow 3 \rightarrow NULL$  

Print the following:  
`
3  
2  
1  
`

**Function Description**  

Complete the *reversePrint* function in the editor below.  

*reversePrint* has the following parameters:  

- *SinglyLinkedListNode pointer head:*  a reference to the head of the list

**Prints**  

The $data$ values of each node in the reversed list.  


**Input Format**

The first line of input contains $t$, the number of test cases.  

The input of each test case is as follows:  

- The first line contains an integer $n$, the number of elements in the list.  
- Each of the next *n* lines contains a data element for a list node.

**Constraints**

- $1 \le n \le 1000$  
- $1 \le list[i] \le 1000$, where $list[i]$ is the $i^{th}$ element in the list.  

**Output Format**

## Solution

**Language:** TypeScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T12:13:43.015Z  

```ts
'use strict';

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

function printSinglyLinkedList(node: SinglyLinkedListNode | null, sep: string): void {
    while (node != null) {
        process.stdout.write(String(node.data));

        node = node.next;

        if (node != null) {
            process.stdout.write(sep);
        }
    }
}

/*
 * Complete the 'reversePrint' function below.
 *
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

function reversePrint(llist: SinglyLinkedListNode): void {
    const stack: number[] = [];

    while (llist != null) {
        stack.push(llist.data);
        llist = llist.next!;
    }

    while (stack.length > 0) {
        console.log(stack.pop());
    }
}

function main() {
    const tests: number = parseInt(readLine().trim(), 10);

    for (let testsItr: number = 0; testsItr < tests; testsItr++) {
        let llist: SinglyLinkedList = new SinglyLinkedList();

        const llistCount: number = parseInt(readLine().trim(), 10);

        for (let i: number = 0; i < llistCount; i++) {
            const llistItem: number = parseInt(readLine().trim(), 10);

            llist.insertNode(llistItem);
        }

        reversePrint(llist.head);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem)