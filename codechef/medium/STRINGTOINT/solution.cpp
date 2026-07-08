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