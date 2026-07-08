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

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T14:42:43.128Z  

```cpp
class Solution {
  public:
    int maxLength(vector<int>& arr) {
        unordered_map<int, int> firstIndex;
        
        int sum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            sum += arr[i];
            
            // If prefix sum is 0, subarray from 0 to i has sum 0
            if (sum == 0) {
                maxLen = i + 1;
            }
            
            // If this sum was seen before, the elements between have sum 0
            if (firstIndex.find(sum) != firstIndex.end()) {
                maxLen = max(maxLen, i - firstIndex[sum]);
            } else {
                firstIndex[sum] = i;
            }
        }
        
        return maxLen;
    }
};
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1)