# 하노이탑

N = int(input())

def hanoi(n, a, b, c):
    if n == 1:
        print(a, c)
    else:
        hanoi(n-1, a, c, b)
        print(a, c)
        hanoi(n-1, b, a, c)

def cal(N):
    if N == 1 :
        return 1
    cnt = 2 * cal(N-1) + 1
    return cnt

print(cal(N))
if N <= 20:
    hanoi(N, 1, 2, 3)