t = int(input())

while t > 0:
    s = input()

    remainder = 0

    for ch in s:
        remainder = (remainder * 10 + int(ch)) % 20

    print(remainder)

    t -= 1