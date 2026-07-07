# PREP59 - Rating 1100

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Valid Parenthesis

If you are new to stacks and queues, or want a refresher on them, start with our Learn Stacks and Queues course

Give string a $S$ consisting of only $($ and $)$. Find whether $S$ is a valid parenthesis string.

Note: A  **valid parentheses**  string is defined as:

- Empty string is valid.
- If $P$ is valid, $(P)$ is also valid.
- If $P$ and $Q$ are valid, $PQ$ is also valid.
### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of a single line of input, containing string $S$.
### Output Format

For each test case, output $1$ if the given string is a valid parenthesis, or output $0$ otherwise.

### Constraints
- $1 \leq T \leq 100$
- $1 \leq |S| \leq 10^5$
- The sum of $|S|$ over all test cases won't exceed $2 \cdot 10^5$.
### Sample 1:
Input
Output

```
3
()(())
(()()
))((

```

```
1
0
0

```

### Explanation:

 **Test case $1$** : $()(())$ will be valid parenthesis.

 **Test case $2$** : $(()()$ will not be valid parenthesis.

 **Test case $3$** : $))(($ will not be valid parenthesis.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-07T20:53:31.358Z  

```cpp
import java.util.*;

class Codechef {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            int balance = 0;
            boolean valid = true;

            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    balance++;
                } else {
                    balance--;
                }

                // closing bracket without matching opening
                if (balance < 0) {
                    valid = false;
                    break;
                }
            }

            if (balance != 0) {
                valid = false;
            }

            System.out.println(valid ? 1 : 0);
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/PREP59)