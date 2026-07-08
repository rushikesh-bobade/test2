# DIFFCONSEC - Rating 879

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Different Consecutive Characters

Chef has a binary string $S$ of length $N$. Chef can perform the following operation on $S$:

- Insert any character ($0$ or $1$) at any position in $S$.

Find the minimum number of operations Chef needs to perform so that no two consecutive characters are same in $S$.

### Input Format
- The first line contains a single integer $T$ — the number of test cases. Then the test cases follow.
- The first line of each test case contains an integer $N$ — the length of the binary string $S$.
- The second line of each test case contains a binary string $S$ of length $N$ containing $0$s and $1$s only.
### Output Format

For each test case, output on a new line the minimum number of operations Chef needs to perform so that no two consecutive characters are same in $S$.

### Constraints
- $1 \leq T \leq 100$
- $1 \le N \le 1000$
### Sample 1:
Input
Output

```
3
2
11
4
0101
5
00100

```

```
1
0
2

```

### Explanation:

 **Test case 1:**  We can perform the following operations: $11 \rightarrow 1\underline{0}1$.

 **Test case 2:**  We do not need to perform any operations.

 **Test case 3:**  We can perform the following operations: $00100 \rightarrow 0\underline{1}0100 \rightarrow 01010\underline{1}0$.

## Solution

**Language:** JavaScript  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-08T15:25:48.853Z  

```js
function Wordle(tests) {
    let t = parseInt(tests[0]);
    let index = 1;
    let ans = [];

    for (let i = 0; i < t; i++) {
        let n = parseInt(tests[index++]);
        let s = tests[index++].trim();

        let count = 0;

        for (let j = 1; j < n; j++) {
            if (s[j] === s[j - 1]) {
                count++;
            }
        }

        ans.push(count);
    }

    console.log(ans.join('\n'));
}

// Input related code. Please do not change.
process.stdin.setEncoding('utf8');
let input = '';

process.stdin.on('data', function(chunk) {
    input += chunk;
});

process.stdin.on('end', function() {
    const tests = input.trim().split('\n');
    Wordle(tests);
});
```

---

[View on CodeChef](https://www.codechef.com/problems/DIFFCONSEC)