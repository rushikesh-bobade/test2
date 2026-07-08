# Zigzag Conversion

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P   A   H   N
A P L S I I G
Y   I   R

```

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

```
string convert(string s, int numRows);

```

 

 **Example 1:** 

```
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

```

 **Example 2:** 

```
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

```

 **Example 3:** 

```
Input: s = "A", numRows = 1
Output: "A"

```

 

 **Constraints:** 

- 1 <= s.length <= 1000
- s consists of English letters (lower-case and upper-case), ',' and '.'.
- 1 <= numRows <= 1000

## Solution

**Language:** Kotlin  
**Runtime:** 5 ms (beats 94.42%)  
**Memory:** 45.5 MB (beats 93.68%)  
**Submitted:** 2026-07-08T14:26:32.870Z  

```kt
class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1 || numRows >= s.length) {
            return s
        }

        val rows = Array(numRows) { StringBuilder() }

        var currentRow = 0
        var direction = -1

        for (ch in s) {
            rows[currentRow].append(ch)

            // Change direction at top and bottom rows
            if (currentRow == 0 || currentRow == numRows - 1) {
                direction *= -1
            }

            currentRow += direction
        }

        val result = StringBuilder()

        for (row in rows) {
            result.append(row)
        }

        return result.toString()
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/zigzag-conversion/)