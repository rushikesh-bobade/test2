def solve():
    t = int(input())

    for _ in range(t):
        n = int(input())
        s = input().strip()

        count = 0

        for i in range(1, n):
            if s[i] == s[i - 1]:
                count += 1

        print(count)

if __name__ == "__main__":
    solve()