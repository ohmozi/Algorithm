# 미로탐색

N, M = map(int, input().split())
dx, dy = [-1,0,1,0],[0,-1,0,1]
mmap=[]

for _ in range(N):
    mmap.append(list(input()))

check = [[0]*M for _ in range(N)]

# def dfs(check, mmap, i, j, cnt):
#     check[i][j] = '1'     # 지나간길 체크
#     for i in range(4):
#         x = i + dx[i]
#         y = j + dy[i]
#         if 0<=x<N and 0<=y<M and mmap[x][y]=='1' and check[x][y]=='0':
#             dfs(check, mmap, x, y, cnt)

def bfs(i, j):
    queue = [[i,j]]
    check[i][j]=1
    while queue:
        current_node = queue.pop(0)
        a = current_node[0]
        b = current_node[1]
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]
            if 0<=x<N and 0<=y<M and mmap[x][y]=='1' and check[x][y]==0:
                check[x][y]=check[a][b]+1
                queue.append([x,y])
                # print("x : {}, y : {}".format(x, y))
        if [N-1,M-1] in queue:
            break



bfs(0,0)

print(check[N-1][M-1])