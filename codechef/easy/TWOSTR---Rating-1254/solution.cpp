t = int(input())

while t > 0:
    x = input()
    y = input()

    possible = True

    for i in range(len(x)):
        if x[i] != '?' and y[i] != '?' and x[i] != y[i]:
            possible = False
            break

    if possible:
        print("Yes")
    else:
        print("No")

    t -= 1