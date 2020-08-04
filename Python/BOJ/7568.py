# 덩치
import sys
input = sys.stdin.readline
N = int(input())
arr=[]
for i in range(N):
    arr.append(list(map(int, input().split())))
place=[0 for i in range(N)]
for i in range(N):
    cnt = 0
    for j in range(N):
        if i == j:
            continue
        if arr[j][0]>arr[i][0] and arr[j][1]>arr[i][1]:
            cnt += 1
    place[i]=cnt+1

for p in place:
    print(p, end=" ")