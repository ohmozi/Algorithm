# 괄호
N = int(input())
for _ in range(N):
    stack  = 0
    string = input()
    for char in string:
        if char == '(':
            stack += 1
        else:
            stack -= 1
        if stack < 0:
            break

    # print(stack)
    if stack==0:
        print("YES")
    else :
        print("NO")
