# Longest Substring Without Repeating Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, find the length of the  **longest**   **substring**  without duplicate characters.

 

 **Example 1:** 

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

```

 **Example 2:** 

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

```

 **Example 3:** 

```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

```

 

 **Constraints:** 

- 0 <= s.length <= 5 * 104
- s consists of English letters, digits, symbols and spaces.

## Solution

**Language:** Python  
**Runtime:** 7 ms (beats 96.47%)  
**Memory:** 19.3 MB (beats 68.10%)  
**Submitted:** 2026-07-08T14:09:13.384Z  

```py
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_index = {}
        left = 0
        max_length = 0

        for right, ch in enumerate(s):
            if ch in char_index and char_index[ch] >= left:
                left = char_index[ch] + 1

            char_index[ch] = right
            max_length = max(max_length, right - left + 1)

        return max_length
```

---

[View on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)