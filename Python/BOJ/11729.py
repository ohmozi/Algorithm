N = int(input())

cnt=0
def hanoi(n, start, mid, end):
    if n == 1:
        print(start, end)
    else:
        hanoi(n-1, start, end, mid)
        print(start, end)
        hanoi(n-1, mid, start, end)
for n in range(N):
    cnt = cnt*2
    cnt +=1
print(cnt)
hanoi(N, 1, 2, 3)