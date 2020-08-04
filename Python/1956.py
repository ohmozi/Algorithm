# 운동
# 플로이드와샬 알고리즘

V, E = map(int, input().split())
inf = 10000000  # 무한대 중요  경로의 최소값을 구해가므로 0이 아니라 무한이어야함
mmap = [[inf] * V for _ in range(V)]

for _ in range(E):
    a, b, c = map(int, input().split())
    mmap[a-1][b-1] = c

# for m in mmap:
#     print(*m)

for i in range(V):
    for j in range(V):
        for k in range(V):
            if mmap[i][j] > mmap[i][k] + mmap[k][j]: # (1,5)가는 방법은 (1,2)-(2,5)와 마찬가지  비교해서 작은값을 업데이트
                mmap[i][j] = mmap[i][k] + mmap[k][j]

# 최종적으로 본인으로 돌아오는 (사이클)의 최소값이 구해짐 (1,1), (2,2) ... 위치 값

result = inf

for i in range(V):
    result = min(result, mmap[i][i])

if result == inf:
    print(-1)
else :
    print(result)


