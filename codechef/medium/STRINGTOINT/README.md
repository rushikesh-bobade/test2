# STRINGTOINT

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Chef and String to Integer

Chef has found a strange string that may contain spaces, signs, numbers, and letters. He wants to  **convert this string into an integer**  by following a few simple rules.

You need to help Chef by writing a program that performs this conversion carefully.

 **Conversion Rules** 

- Ignore spaces: Skip all leading spaces before any character.
- Check the sign: If the next character is '-', the number is negative. If the next character is '+', the number is positive. If no sign is given, assume it is positive.
- Read digits only: Read all consecutive digits and stop when a non-digit character is found. If no digits are found, the result is 0.
- Clamp within range: If the number is smaller than -2147483648, return -2147483648. If the number is larger than 2147483647, return 2147483647.
## Function Declaration
### Function Name

$myAtoi$ – This function converts a given string into a 32-bit signed integer by following specific conversion rules similar to the standard `atoi` function.

### Parameters
- $s$ : A string that may contain leading spaces, optional sign characters (+ or -), digits, and other non-digit characters.
### Return Value
- Returns an integer obtained after converting the string according to the given rules.
- If no valid number can be formed, the function returns 0.
- If the converted number is smaller than -2147483648, it returns -2147483648.
- If the converted number is larger than 2147483647, it returns 2147483647.
### Input Format
- The first line contains an integer $T$ — the number of test cases.
- Each of the next $T$ lines contains one string $S$.
### Output Format
- For each test case, print the converted integer on a new line.
### Constraints
- $1 \le T \le 100$
- $0 \le |S| \le 200$
- $\texttt{S may contain letters, digits, spaces, '+', '-', and '.'}$
### Sample 1:
Input
Output

```
5
   98hello
-00456
+45abc23
word123
  -91283472332

```

```
98
-456
45
0
-2147483648

```

### Explanation:

 **Test case 1** :
`" 98hello"` -> ignore spaces -> read digits `98` -> result =  **98** 

 **Test case 2** :
`"-00456"` -> negative sign -> read digits `456` -> result =  **-456** 

 **Test case 3** :
`"+45abc23"` -> sign `+` -> read digits `45` -> result =  **45** 

 **Test case 4** :
`"word123"` -> starts with non-digit ? no number found -> result =  **0** 

 **Test case 5** :
`"-91283472332"` -> number is too small -> clamp to  **-2147483648**

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T13:07:09.967Z  

```cpp
def myAtoi(s: str) -> int:
    i = 0
    n = len(s)

    # Ignore leading spaces
    while i < n and s[i] == ' ':
        i += 1

    # Check sign
    sign = 1
    if i < n and (s[i] == '+' or s[i] == '-'):
        if s[i] == '-':
            sign = -1
        i += 1

    # Read digits
    num = 0
    while i < n and s[i].isdigit():
        num = num * 10 + (ord(s[i]) - ord('0'))
        
        # Clamp while building number
        if sign * num < -2147483648:
            return -2147483648
        if sign * num > 2147483647:
            return 2147483647

        i += 1

    return sign * num
```

---

[View on CodeChef](https://www.codechef.com/problems/STRINGTOINT)