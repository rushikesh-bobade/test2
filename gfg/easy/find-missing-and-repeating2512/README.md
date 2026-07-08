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

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T13:25:29.505Z  

```js
/**
 * @param {number[]} arr
 * @returns {number[]}
 */
class Solution {
    findTwoElement(arr) {
        const n = arr.length;

        let xorVal = 0;

        // XOR all array elements
        for (let num of arr) {
            xorVal ^= num;
        }

        // XOR numbers from 1 to n
        for (let i = 1; i <= n; i++) {
            xorVal ^= i;
        }

        // Get rightmost set bit
        let setBit = xorVal & -xorVal;

        let x = 0;
        let y = 0;

        // Divide array elements into two groups
        for (let num of arr) {
            if (num & setBit) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        // Divide numbers 1 to n into two groups
        for (let i = 1; i <= n; i++) {
            if (i & setBit) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        // Find which is repeating and which is missing
        let count = 0;
        for (let num of arr) {
            if (num === x) count++;
        }

        if (count === 2) {
            return [x, y];
        } else {
            return [y, x];
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1)