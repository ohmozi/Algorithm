# 유기농배추
# BFS

T = int(input())
dx, dy = [-1,0,1,0],[0,-1,0,1]

def bfs(i, j):
    queue = [[i,j]]
    mmap[i][j] = 0
    count = 1
    while queue:
        current_node = queue.pop(0)
        a = current_node[0]
        b = current_node[1]
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]
            if 0<=x<N and 0<=y<M and mmap[x][y]==1:
                mmap[x][y] = 0
                queue.append([x,y])
                count += 1

    cnt.append(count)

for _ in range(T):
    M, N, K = map(int, input().split())
    mmap = [[0]*M for _ in range(N)]
    cnt = []
    for _ in range(K):
        x, y = map(int, input().split())
        mmap[y][x] = 1

    for i in range(N):
        for j in range(M):
            if mmap[i][j] == 1:
                bfs(i, j)

    print(len(cnt))
