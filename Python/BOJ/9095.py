# 1,2,3 더하기
# DP
# 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

import sys
input = sys.stdin.readline
T = int(input())
N = []

for _ in range(T):
    N.append(int(input()))

for i in N:
    lst = [i]
    cnt = 0
    while lst:
        temp_list = []
        for j in lst:
            for a in range(1,4):
                if j - a == 0:
                    cnt += 1
                if j - a >0:
                    temp_list.append(j-a)
        # print(temp_list)
        lst = temp_list

    print(cnt)