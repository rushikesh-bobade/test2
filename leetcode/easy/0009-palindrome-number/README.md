# Palindrome Number

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer `x`, return `true` *if* `x` *is a   palindrome , and* `false` *otherwise*.

 

 **Example 1:** 

```
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

```

 **Example 2:** 

```
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

```

 **Example 3:** 

```
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

```

 

 **Constraints:** 

- -231 <= x <= 231 - 1

 

 **Follow up:**  Could you solve it without converting the integer to a string?

## Solution

**Language:** Kotlin  
**Runtime:** 5 ms (beats 99.91%)  
**Memory:** 45.6 MB (beats 67.00%)  
**Submitted:** 2026-07-08T14:50:19.767Z  

```kt
class Solution {
    fun isPalindrome(x: Int): Boolean {
        // Negative numbers cannot be palindrome
        if (x < 0) return false
        
        // Numbers ending with 0 (except 0 itself) cannot be palindrome
        if (x % 10 == 0 && x != 0) return false
        
        var num = x
        var reversed = 0
        
        // Reverse only half of the number
        while (num > reversed) {
            reversed = reversed * 10 + num % 10
            num /= 10
        }
        
        // For even digits: num == reversed
        // For odd digits: num == reversed / 10 (middle digit ignored)
        return num == reversed || num == reversed / 10
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindrome-number/)