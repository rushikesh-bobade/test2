# Missing And Repeating

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an unsorted array  **arr[]** of size  **n**, containing elements from the range  **1** to **n**, it is known that one number in this range is  **missing**, and another number  **occurs twice**  in the array, find both the  **duplicate** number and the  **missing** number.

**Examples:
**

```
Input: arr[] = [2, 2]
Output: [2, 1]
Explanation: Repeating number is 2 and the missing number is 1.
```

```
Input: arr[] = [1, 3, 3] 
Output: [3, 2]
Explanation: Repeating number is 3 and the missing number is 2.
```

```
Input: arr[] = [4, 3, 6, 2, 1, 1]
Output: [1, 5]
Explanation: Repeating number is 1 and the missing number is 5.
```

 **Constraints:** 
2 ≤ n ≤ 106
1 ≤ arr[i] ≤ n

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T13:23:45.476Z  

```py
class Solution:
    def findTwoElement(self, arr):
        n = len(arr)

        xor_val = 0

        # XOR all array elements and numbers from 1 to n
        for num in arr:
            xor_val ^= num

        for i in range(1, n + 1):
            xor_val ^= i

        # Find rightmost set bit
        set_bit = xor_val & -xor_val

        x = 0
        y = 0

        # Divide numbers into two groups
        for num in arr:
            if num & set_bit:
                x ^= num
            else:
                y ^= num

        for i in range(1, n + 1):
            if i & set_bit:
                x ^= i
            else:
                y ^= i

        # Determine which one is repeating
        if x in arr:
            return [x, y]
        else:
            return [y, x]
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1)