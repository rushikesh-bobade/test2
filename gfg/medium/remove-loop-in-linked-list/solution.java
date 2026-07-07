
        // Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // No loop exists
        if (slow != fast) {
            return;
        }

        // Find the starting point of loop
        slow = head;

        // If loop starts at head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            // Move both pointers until they reach the node before loop start
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Remove loop
        fast.next = null;
    }
}