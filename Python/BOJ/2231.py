# 분해합
import sys
input = sys.stdin.readline
N = int(input())
temp = N
digit=0
while(temp>0):
    temp = temp//10
    digit+=1
# print("digit: ", digit)
start = N-(digit*9)
if start<=0:
    start = 1
# print("start: ", start)
find = False
for i in  range(start,N+1):
    number = i
    hop = i
    while(i>0):
        hop = hop + i%10
        i= i//10
    if hop==N:
        find = True
        result = number
        break;
if find == True:
    print(result)
else:
    print("0")