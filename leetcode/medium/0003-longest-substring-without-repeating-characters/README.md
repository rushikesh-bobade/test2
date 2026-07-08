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
**Runtime:** 0 ms  
**Memory:** 4 MB  
**Submitted:** 2026-07-08T14:09:53.228Z  

```py
func lengthOfLongestSubstring(s string) int {
    charIndex := make(map[byte]int)
    left := 0
    maxLength := 0

    for right := 0; right < len(s); right++ {
        if index, found := charIndex[s[right]]; found && index >= left {
            left = index + 1
        }

        charIndex[s[right]] = right

        if right-left+1 > maxLength {
            maxLength = right - left + 1
        }
    }

    return maxLength
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)