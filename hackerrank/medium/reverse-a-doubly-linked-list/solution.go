

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
 *     data int32
 *     next *DoublyLinkedListNode
 *     prev *DoublyLinkedListNode
 * }
 *
 */

func reverse(llist *DoublyLinkedListNode) *DoublyLinkedListNode {
    if llist == nil {
        return nil
    }

    current := llist
    var temp *DoublyLinkedListNode

    for current != nil {
        // Swap next and prev
        temp = current.prev
        current.prev = current.next
        current.next = temp

        // Move to the original next node
        current = current.prev
    }

    // temp points to the previous node of the new head
    if temp != nil {
        return temp.prev
    }

    return llist
}

