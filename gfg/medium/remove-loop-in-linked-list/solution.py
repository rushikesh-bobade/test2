class Solution:
    def removeLoop(self, head):
        if head is None:
            return

        slow = head
        fast = head

        # Detect loop
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                break
        else:
            return  # No loop

        # Find start of loop
        slow = head

        if slow == fast:
            # Loop starts at head
            while fast.next != slow:
                fast = fast.next
        else:
            while slow.next != fast.next:
                slow = slow.next
                fast = fast.next

        # Remove loop
        fast.next = None