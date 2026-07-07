        // Detect loop
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;

            if (slow == fast) {
                break;
            }
        }

        // No loop present
        if (slow != fast) {
            return;
        }

        // Find start of loop
        slow = head;

        // Loop starts at head
        if (slow == fast) {
            while (fast->next != slow) {
                fast = fast->next;
            }
        } 
        else {
            // Move both pointers until they reach node before loop start
            while (slow->next != fast->next) {
                slow = slow->next;
                fast = fast->next;
            }
        }

        // Remove loop
        fast->next = nullptr;
    }
};