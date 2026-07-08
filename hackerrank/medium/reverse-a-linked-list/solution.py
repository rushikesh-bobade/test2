

#
# Complete the 'reverse' function below.
#
# The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
# The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
#

#
# For your reference:
#
# SinglyLinkedListNode:
#     int data
#     SinglyLinkedListNode next
#
#

def reverse(llist):
    prev = None
    current = llist

    while current:
        next_node = current.next   # save next node
        current.next = prev        # reverse pointer
        prev = current             # move prev forward
        current = next_node        # move current forward

    return prev

