# Remove loop in Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the **head** of a singly linked list, the task is to  **remove a cycle**  if present. A cycle exists when a node's next pointer points back to a previous node, forming a loop.

- Internally, a variable pos is used to denotes the position of the node where the cycle starts, but it is not passed as a parameter.
- The linked list remains as it is if there is cycle in the list.
- The output will be "true" if your code works according to expectations, otherwise "false". 

 **Examples:** 

```
Input: head = 1 -> 3 -> 4, pos = 2
Output: true
Explanation: The linked list looks like

A loop is present in the list, and it is removed.

```

```
Input: head = 1 -> 8 -> 3 -> 4, pos = 0
Output: true
Explanation: 

The Linked list does not contains any loop. 
```

```
Input: head = 1 -> 2 -> 3 -> 4, pos = 1
Output: true
Explanation: The linked list looks like 

A loop is present in the list, and it is removed.
```

 **Constraints:** 
1 ≤ size of linked list ≤ 105

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-07T21:43:15.501Z  

```cpp
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
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1)