# 제로
import sys
input = sys.stdin.readline
K = int(input())

result = []

for _ in range(K):
    n = int(input())
    if n:
        result.append(n)
    else:
        del result[-1]

print(sum(result))