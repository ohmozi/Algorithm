# 스택
import sys
input = sys.stdin.readline
N = int(input())

stack = []
for _ in range(N):
    input_split = input().split()
    oper = input_split[0]

    if oper == 'push':
        stack.append(int(input_split[1]))
    elif oper == 'pop':
        if stack:
            num = stack[-1]
            del stack[-1]
            print(num)
        else:
            print(-1)
    elif oper == 'size':
        print(len(stack))
    elif oper == 'empty':
        if stack:
            print(0)
        else:
            print(1)
    elif oper == 'top':
        if stack:
            print(stack[-1])
        else:
            print(-1)