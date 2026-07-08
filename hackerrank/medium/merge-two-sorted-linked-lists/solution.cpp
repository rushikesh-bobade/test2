#include <bits/stdc++.h>
using namespace std;

class SinglyLinkedListNode {
public:
    int data;
    SinglyLinkedListNode* next;

    SinglyLinkedListNode(int node_data) {
        data = node_data;
        next = nullptr;
    }
};

class SinglyLinkedList {
public:
    SinglyLinkedListNode* head;
    SinglyLinkedListNode* tail;

    SinglyLinkedList() {
        head = nullptr;
        tail = nullptr;
    }

    void insert_node(int node_data) {
        SinglyLinkedListNode* node = new SinglyLinkedListNode(node_data);

        if (!head) {
            head = node;
        } else {
            tail->next = node;
        }

        tail = node;
    }
};

SinglyLinkedListNode* mergeLists(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2) {
    SinglyLinkedListNode* dummy = new SinglyLinkedListNode(0);
    SinglyLinkedListNode* curr = dummy;

    while (head1 && head2) {
        if (head1->data <= head2->data) {
            curr->next = head1;
            head1 = head1->next;
        } else {
            curr->next = head2;
            head2 = head2->next;
        }
        curr = curr->next;
    }

    if (head1)
        curr->next = head1;
    else
        curr->next = head2;

    return dummy->next;
}

void printList(SinglyLinkedListNode* node) {
    while (node) {
        cout << node->data;
        if (node->next)
            cout << " ";
        node = node->next;
    }
}

int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        SinglyLinkedList list1;
        for (int i = 0; i < n; i++) {
            int x;
            cin >> x;
            list1.insert_node(x);
        }

        cin >> n;

        SinglyLinkedList list2;
        for (int i = 0; i < n; i++) {
            int x;
            cin >> x;
            list2.insert_node(x);
        }

        SinglyLinkedListNode* result = mergeLists(list1.head, list2.head);

        printList(result);
        cout << "\n";
    }

    return 0;
}
