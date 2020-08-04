# 1로만들기
# DP
# 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
#
# X가 3으로 나누어 떨어지면, 3으로 나눈다.
# X가 2로 나누어 떨어지면, 2로 나눈다.
# 1을 뺀다.
# 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

import sys
input = sys.stdin.readline
N = int(input())

lst = [N]
# print(list)
count = 0

while 1:
    if 1 in lst:
        print(count)
        break

    temp_list = []
    for number in lst:
        if number % 3 == 0:
            temp_list.append(number//3)
        if number % 2 == 0:
            temp_list.append(number//2)
        temp_list.append(number-1)

    lst = temp_list
    count += 1
    # print(lst)
