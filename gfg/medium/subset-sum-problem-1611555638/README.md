# Subset Sum Problem

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of positive integers  **arr[]**  and a value  **sum**, determine if there is a subset of  **arr[]**  with sum equal to given  **sum**. 

 **Examples:** 

```
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.

```

```
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
```

```
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
```

 **Constraints:** 
1 <= arr.size() <= 200
1<= arr[i] <= 200
1<= sum <= 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T15:39:54.553Z  

```java
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int num : arr) {
            for (int target = sum; target >= num; target--) {
                if (dp[target - num]) {
                    dp[target] = true;
                }
            }
        }

        return dp[sum];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1)