# 단지번호붙이기
# 이어진 섬찾기
# BFS

N = int(input())
map = []
for _ in range(N):
    map.append(list(input()))
dx, dy = [-1,0,1,0], [0,-1,0,1]
cnt = []
def bfs(x, y):
    queue = [[x, y]]
    map[x][y] = '0'
    count = 1
    while queue:
        current_node = queue.pop(0)
        a = current_node[0]
        b = current_node[1]
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]
            if 0<=x<N and 0<=y<N and map[x][y]=='1':
                map[x][y] = '0'
                queue.append([x,y])
                count += 1
    cnt.append(count)

for i in range(N):
    for j in range(N):
        if map[i][j] == '1':
            bfs(i,j)

cnt.sort()
print(len(cnt))
for value in cnt:
    print(value)
