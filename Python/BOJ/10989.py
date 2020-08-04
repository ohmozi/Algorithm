import sys
N = int(sys.stdin.readline())


sort_list=[0 for _ in range(10001)]
# for num in sys.stdin:
#     sort_list[num] +=1

for _ in range(N):
    sort_list[int(sys.stdin.readline())] +=1

for i in range(10001):
    if sort_list[i]>0:
        for j in range(sort_list[i]):
            print(i)
