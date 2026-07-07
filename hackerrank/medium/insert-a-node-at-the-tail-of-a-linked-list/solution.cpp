#include <bits/stdc++.h>
using namespace std;

class Node {
public:
    int data;
    Node* next;

    Node(int data) {
        this->data = data;
        this->next = nullptr;
    }
};

Node* insertAtTail(Node* head, int data) {
    Node* newNode = new Node(data);

    if (head == nullptr) {
        return newNode;
    }

    Node* temp = head;

    while (temp->next != nullptr) {
        temp = temp->next;
    }

    temp->next = newNode;

    return head;
}

void printList(Node* head) {
    while (head != nullptr) {
        cout << head->data << endl;
        head = head->next;
    }
}

int main() {
    int n;
    cin >> n;

    Node* head = nullptr;

    for (int i = 0; i < n; i++) {
        int data;
        cin >> data;

        head = insertAtTail(head, data);
    }

    printList(head);

    return 0;
}
