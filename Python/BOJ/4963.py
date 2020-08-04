# 섬의 개수

dx, dy = [-1, 0, 1, 0, -1, -1, 1, 1], [0, -1, 0, 1, -1, 1, -1, 1]  # 가로세로대각 8가지

def bfs(i, j):
    global sum
    sum += 1
    queue = [[i, j]]
    check[i][j] = 1

    while queue:
        element = queue.pop(0)
        _x = element[0]
        _y = element[1]
        for i in range(8):
            x = _x + dx[i]
            y = _y + dy[i]
            if 0 <= x < h and 0 <= y < w and check[x][y] == 0 and mmap[x][y] == 1:
                check[x][y] = 1
                queue.append([x, y])


while (1):
    w, h = map(int, input().split())

    if w == 0:
        break

    check = [[0] * w for _ in range(h)]

    mmap = []
    for _ in range(h):
        mmap.append(list(map(int, input().split())))

    sum = 0
    for i in range(h):
        for j in range(w):
            if mmap[i][j] == 1 and check[i][j] == 0:
                bfs(i, j)
    print(sum)

# print(mmap)
