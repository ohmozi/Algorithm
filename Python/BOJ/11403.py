# 경로찾기
N = int(input())
mmap = []
for _ in range(N):
    mmap.append(list(map(int,input().split())))

way = [[0]*N for _ in range(N)]

def bfs(start_node):
    foot_prints = []
    queue = [start_node]
    while queue:
        current_node = queue.pop(0)
        for search_node in range(len(mmap[current_node])):
            if mmap[current_node][search_node] and search_node not in foot_prints:
                foot_prints.append(search_node)
                queue.append(search_node)
    return foot_prints

for i in range(N):
    list = bfs(i)
    for index in list:
        way[i][index] = 1

for a in range(N):
    for b in range(N):
        print(way[a][b], end=' ')
    print()