#연산자 끼워넣기
# 연산을 앞에서부터 차례로 하니까 가능한 문제
# 연산순서대로 한다면 다르게 해야할듯
import sys
import itertools
input = sys.stdin.readline

N = int(input())
num_list = list(map(int,input().split()))
oper_num = list(map(int, input().split()))
op = ['+', '-', '*', '/']
max = -sys.maxsize -1
min = sys.maxsize
# print(max)
# print(oper_num)
oper=[]
for i in range(4):
    operation = op[i]
    operation_count = operation*oper_num[i]
    oper.extend(operation_count)
# print(oper)
case_list= set(itertools.permutations(oper,N-1))
# print(case_list)

# idx = 0
for case in case_list:
    total = num_list[0]
    # print("index :{}".format(idx))
    # idx+=1
    for i in range(N-1):
        # print(case[i],end=",")
        if case[i] == '+':
            total += num_list[i+1]
        elif case[i] == '-':
            total -= num_list[i+1]
        elif case[i] == '*':
            total *= num_list[i+1]
        else:
            if total<0:
                total = -total
                total //= num_list[i+1]
                total = -total
            else:
                total //= num_list[i+1]
        # print(total)
    # print(total)
    if total>max:
        max = total
    if total<min:
        min = total
    # print()
# print("max : {}, min : {}".format(max, min))
# oper_mix = list(list(itertools.permutations(oper,len(oper))))
# print(oper_mix)
print(max)
print(min)