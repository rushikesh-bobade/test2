

# Complete the mergeLists function below.

#
# For your reference:
#
# SinglyLinkedListNode:
#     int data
#     SinglyLinkedListNode next
#
#
def mergeLists(head1, head2):
    # Dummy node to simplify handling the head
    dummy = SinglyLinkedListNode(0)
    current = dummy

    while head1 and head2:
        if head1.data <= head2.data:
            current.next = head1
            head1 = head1.next
        else:
            current.next = head2
            head2 = head2.next
        
        current = current.next

    # Attach remaining nodes
    if head1:
        current.next = head1
    else:
        current.next = head2

    return dummy.next
