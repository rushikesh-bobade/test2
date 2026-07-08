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

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T12:09:28.781Z  

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

void print_singly_linked_list(SinglyLinkedListNode* node, string sep) {
    while (node) {
        cout << node->data;

        node = node->next;

        if (node) {
            cout << sep;
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
 *     int data;
 *     SinglyLinkedListNode* next;
 * };
 *
 */

void reversePrint(SinglyLinkedListNode* llist) {
    stack<int> st;

    while (llist != nullptr) {
        st.push(llist->data);
        llist = llist->next;
    }

    while (!st.empty()) {
        cout << st.top() << endl;
        st.pop();
    }
}

int main()
{
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

        reversePrint(llist->head);
    }

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

[View on HackerRank](https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem)