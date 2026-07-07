# Longest Subarray with Sum K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **`arr[]`**  containing integers and an integer  **`k`**, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value  **`k`**. If there is no subarray with sum equal to  **`k`**, return  **`0`**.

 **Examples:** 

```
Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
```

```
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Subarrays with sum = -5 are [-5] and [-5, 8, -14, 2, 4]. The length of the longest subarray with a sum of -5 is 5.
```

```
Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
```

 **Constraints:** 
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104
-109 ≤ k ≤ 109

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-07T21:05:10.728Z  

```js
/**
 * @param {number[]} arr
 * @param {number} k
 * @returns {number}
 */
class Solution {
    longestSubarray(arr, k) {
        let map = new Map();
        let sum = 0;
        let maxLen = 0;

        for (let i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Subarray from index 0 to i
            if (sum === k) {
                maxLen = i + 1;
            }

            // Check if prefix sum (sum - k) exists
            if (map.has(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            // Store first occurrence only
            if (!map.has(sum)) {
                map.set(sum, i);
            }
        }

        return maxLen;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1)