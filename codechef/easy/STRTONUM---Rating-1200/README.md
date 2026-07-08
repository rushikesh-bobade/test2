# STRTONUM - Rating 1200

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Convert string to number

You are given a string that represents a positive number. Your task is to write a program that converts this string into its numerical equivalent without using any in-built parsing, conversion libraries, or direct type casting methods. The string will not contain any leading zeros, decimals, or any non-numeric characters.

Complete the function  **stringToNumber**  in the IDE

### Input Format
- The first line contains a single integer, T, the number of test cases.
- The following T lines each contain a single string, S, representing the number.
### Output Format

For each test case, print the numerical equivalent of the string.

### Constraints
- $1 \leq T \leq 100$
- $1 \leq |S| \leq 10$, where $|S|$ is the length of the string.
- S will only contain digits (0-9) and will not have leading zeros.
### Sample 1:
Input
Output

```
3
123
42
1001
```

```
123
42
1001
```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T12:15:19.778Z  

```cpp
public static long stringToNumber(String str) {
    long num = 0;

    for (int i = 0; i < str.length(); i++) {
        int digit = str.charAt(i) - '0';
        num = num * 10 + digit;
    }

    return num;
}
```

---

[View on CodeChef](https://www.codechef.com/problems/STRTONUM)