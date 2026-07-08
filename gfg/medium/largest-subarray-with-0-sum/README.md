# Largest subarray with 0 sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]** containing both positive and negative integers, the task is to find the  **length**  of the  **longest**  **subarray**  with a sum equals to  **0.** 

 **Note:** A subarray is a contiguous part of an array, formed by selecting one or more consecutive elements while maintaining their original order.

 **Examples:** 

```
Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].
```

```
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
```

```
Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The longest subarray with sum equals to 0 is [0, -4, 3, 1, 0]
```

 **Constraints:** 
1 ≤ arr.size() ≤ 106
−103 ≤ arr[i] ≤ 103

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T14:40:42.125Z  

```py
class Solution:
    def maxLength(self, arr):
        prefix_sum = 0
        max_len = 0
        first_index = {}

        for i, num in enumerate(arr):
            prefix_sum += num

            # Subarray from index 0 to i has sum 0
            if prefix_sum == 0:
                max_len = i + 1

            # If prefix sum was seen before, the middle part has sum 0
            if prefix_sum in first_index:
                max_len = max(max_len, i - first_index[prefix_sum])
            else:
                first_index[prefix_sum] = i

        return max_len
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1)