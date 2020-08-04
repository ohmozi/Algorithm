# 2×n 타일링
# DP
#
# 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
# 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
N = int(input())
dp = [0]*N

def c_dp(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    if dp[n-1]:
        return dp[n-1]
    else :
        dp[n-1] = c_dp(n-1) + c_dp(n-2)
        return  dp[n-1]

print(c_dp(N)%10007)

# N을 1, 2 로 채우는 방법
'''
lst = [N]
kind_cnt = 0

while lst:
    temp_list = []
    for i in lst:
        for a in range(1,3):
            if i-a == 0:
                kind_cnt += 1
                if kind_cnt > 10007:
                    kind_cnt = kind_cnt%10007

            elif i-a > 0:
                temp_list.append(i-a)

    # print(temp_list)
    lst = temp_list

print(kind_cnt)
'''
