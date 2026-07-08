# Reverse a linked list

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

<sub>This challenge is part of a tutorial track by [MyCodeSchool](http://www.youtube.com/mycodeschool) and is accompanied by a video lesson.</sub>

Given the pointer to the head node of a linked list, change the <code>next</code> pointers of the nodes so that their order is reversed. The head pointer given may be null meaning that the initial list is empty.  

**Example**  
$head$ references the list $1 \rightarrow 2 \rightarrow 3 \rightarrow NULL$  

Manipulate the $next$ pointers of each node in place and return $head$, now referencing the head of the list $3 \rightarrow 2 \rightarrow 1 \rightarrow NULL$.  

**Function Description**  

Complete the *reverse* function in the editor below.  

*reverse* has the following parameter:  

- *SinglyLinkedListNode pointer head:*  a reference to the head of a list  

**Returns**  

- *SinglyLinkedListNode pointer:*  a reference to the head of the reversed list  
 

**Input Format**

The first line contains an integer $t$, the number of test cases.  

Each test case has the following format:  

The first line contains an integer $n$, the number of elements in the linked list.  
Each of the next $n$ lines contains an integer, the $data$ values of the elements in the linked list.  

**Constraints**

- $1 \le t \le 10$  
- $1 \le n \le 1000$  
- $1 \le list[i] \le 1000$, where $list[i]$ is the $i^{th}$ element in the list.


**Output Format**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T15:44:31.004Z  

```cpp
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

class SinglyLinkedListNode {
    public:
        int data;
        SinglyLinkedListNode *next;

        SinglyLinkedListNode(int node_data) {
            this->data = node_data;
            this->next = nullptr;
        }
};

class SinglyLinkedList {
    public:
        SinglyLinkedListNode *head;
        SinglyLinkedListNode *tail;

        SinglyLinkedList() {
            this->head = nullptr;
            this->tail = nullptr;
        }

        void insert_node(int node_data) {
            SinglyLinkedListNode* node = new SinglyLinkedListNode(node_data);

            if (!this->head) {
                this->head = node;
            } else {
                this->tail->next = node;
            }

            this->tail = node;
        }
};

void print_singly_linked_list(SinglyLinkedListNode* node, string sep, ofstream& fout) {
    while (node) {
        fout << node->data;

        node = node->next;

        if (node) {
            fout << sep;
        }
    }
}

/*
 * Complete the 'reverse' function below.
 *
 * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
 * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
 */

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */

SinglyLinkedListNode* reverse(SinglyLinkedListNode* llist) {
    SinglyLinkedListNode* prev = nullptr;
    SinglyLinkedListNode* current = llist;

    while (current != nullptr) {
        SinglyLinkedListNode* next = current->next; // save next node
        current->next = prev;                       // reverse pointer
        prev = current;                             // move prev forward
        current = next;                             // move current forward
    }

    return prev; // new head of reversed list
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string tests_temp;
    getline(cin, tests_temp);

    int tests = stoi(ltrim(rtrim(tests_temp)));

    for (int tests_itr = 0; tests_itr < tests; tests_itr++) {
        SinglyLinkedList* llist = new SinglyLinkedList();

        string llist_count_temp;
        getline(cin, llist_count_temp);

        int llist_count = stoi(ltrim(rtrim(llist_count_temp)));

        for (int i = 0; i < llist_count; i++) {
            string llist_item_temp;
            getline(cin, llist_item_temp);

            int llist_item = stoi(ltrim(rtrim(llist_item_temp)));

            llist->insert_node(llist_item);
        }

        SinglyLinkedListNode* llist1 = reverse(llist->head);

        print_singly_linked_list(llist1, " ", fout);
        fout << "\n";
    }

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/reverse-a-linked-list/problem)