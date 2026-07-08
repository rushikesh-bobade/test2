# PALINDRCHECK

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Reverse Words in a String

You are given a string $s$ consisting of English letters (uppercase and lowercase), digits, and spaces `' '`. The string may contain leading or trailing spaces, or multiple spaces between words.

Your task is to  **reverse the order of the words**  in the string. A word is defined as a sequence of non-space characters.

The resulting string should:

- Contain words in reversed order.
- Have only single spaces separating words.
- Not contain leading or trailing spaces.
## Function Declaration
### Function Name

$reverseWords$ – This function reverses the order of words in a given string while ensuring that words are separated by exactly one space and there are no leading or trailing spaces.

### Parameters
- $s$ : A string consisting of English letters (uppercase and lowercase), digits, and spaces ' '.
### Return Value
- Returns a string containing the words of $s$ in reversed order.
- The returned string: Contains words separated by a single space. Has no leading or trailing spaces.
## Constraints
- $1 \le |s| \le 10^4$
- The string $s$ contains: Uppercase English letters ($A–Z$) Lowercase English letters ($a–z$) Digits ($0–9$) Space characters (' ')
- The string may contain: Leading spaces Trailing spaces Multiple consecutive spaces between words
- There is at least one word in $s$.
### Input Format
- The first line contains a single string $s$.
### Output Format
- Print a single line containing the words of $s$ in reversed order.
- Words must be separated by exactly one space.
- There must be no leading or trailing spaces in the output.
### Sample 1:
Input
Output

```
OpenAI   creates amazing   AI   models  

```

```
models AI amazing creates OpenAI

```

### Sample 2:
Input
Output

```
Data   Science is fun

```

```
fun is Science Data

```

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T14:33:24.649Z  

```py
def reverseWords(s: str) -> str:
    words = s.split()

    words.reverse()

    return " ".join(words)
```

---

[View on CodeChef](https://www.codechef.com/problems/PALINDRCHECK)