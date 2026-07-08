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

**Language:** c_cpp  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T14:32:37.025Z  

```c_cpp
string reverseWords(string s) {
    vector<string> words;
    string word;

    stringstream ss(s);

    while (ss >> word) {
        words.push_back(word);
    }

    reverse(words.begin(), words.end());

    string result;

    for (int i = 0; i < words.size(); i++) {
        if (i > 0) {
            result += " ";
        }
        result += words[i];
    }

    return result;
}
```

---

[View on CodeChef](https://www.codechef.com/problems/PALINDRCHECK)