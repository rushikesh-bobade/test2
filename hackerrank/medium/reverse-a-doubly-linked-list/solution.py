

#
# Complete the 'reverse' function below.
#
# The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
# The function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
#

#
# For your reference:
#
# DoublyLinkedListNode:
#     int data
#     DoublyLinkedListNode next
#     DoublyLinkedListNode prev
#
#

def reverse(llist):
    if llist is None:
        return None

    current = llist
    temp = None

    while current:
        # Swap next and prev
        temp = current.prev
        current.prev = current.next
        current.next = temp

        # Move to the original next node
        current = current.prev

    # Return the new head
    if temp:
        return temp.prev

    return llist

