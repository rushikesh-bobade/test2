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

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T14:01:02.820Z  

```cpp
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

class DoublyLinkedListNode {
    public:
        int data;
        DoublyLinkedListNode *next;
        DoublyLinkedListNode *prev;

        DoublyLinkedListNode(int node_data) {
            this->data = node_data;
            this->next = nullptr;
            this->prev = nullptr;
        }
};

class DoublyLinkedList {
    public:
        DoublyLinkedListNode *head;
        DoublyLinkedListNode *tail;

        DoublyLinkedList() {
            this->head = nullptr;
            this->tail = nullptr;
        }

        void insert_node(int node_data) {
            DoublyLinkedListNode* node = new DoublyLinkedListNode(node_data);

            if (!this->head) {
                this->head = node;
            } else {
                this->tail->next = node;
                node->prev = this->tail;
            }

            this->tail = node;
        }
};

void print_doubly_linked_list(DoublyLinkedListNode* node, string sep, ofstream& fout) {
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
 * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
 * The function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
 */

/*
 * For your reference:
 *
 * DoublyLinkedListNode {
 *     int data;
 *     DoublyLinkedListNode* next;
 *     DoublyLinkedListNode* prev;
 * };
 *
 */

DoublyLinkedListNode* reverse(DoublyLinkedListNode* llist) {
    DoublyLinkedListNode* current = llist;
    DoublyLinkedListNode* temp = nullptr;

    while (current != nullptr) {
        // Swap next and prev
        temp = current->prev;
        current->prev = current->next;
        current->next = temp;

        // Move to the next node (original next)
        current = current->prev;
    }

    // Return the new head
    if (temp != nullptr)
        return temp->prev;

    return llist;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string t_temp;
    getline(cin, t_temp);

    int t = stoi(ltrim(rtrim(t_temp)));

    for (int t_itr = 0; t_itr < t; t_itr++) {
        DoublyLinkedList* llist = new DoublyLinkedList();

        string llist_count_temp;
        getline(cin, llist_count_temp);

        int llist_count = stoi(ltrim(rtrim(llist_count_temp)));

        for (int i = 0; i < llist_count; i++) {
            string llist_item_temp;
            getline(cin, llist_item_temp);

            int llist_item = stoi(ltrim(rtrim(llist_item_temp)));

            llist->insert_node(llist_item);
        }

        DoublyLinkedListNode* llist1 = reverse(llist->head);

        print_doubly_linked_list(llist1, " ", fout);
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

[View on HackerRank](https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem)