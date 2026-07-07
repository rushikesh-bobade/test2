

// Complete the insertNodeAtTail function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
function insertNodeAtTail(head, data) {
    const newNode = new SinglyLinkedListNode(data);

    // If linked list is empty
    if (head === null) {
        return newNode;
    }

    // Traverse to the last node
    let current = head;

    while (current.next !== null) {
        current = current.next;
    }

    // Insert new node at tail
    current.next = newNode;

    return head;
}

