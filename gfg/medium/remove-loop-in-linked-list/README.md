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

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-07T21:41:21.586Z  

```py
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
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1)