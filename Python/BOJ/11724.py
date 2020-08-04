# 연결요소
# 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

# 시간초과  pypy3로 제출

N, M = map(int, input().split())

mmap = [[0]*N for _ in range(N)]

for _ in range(M):
    start, end = map(int, input().split())
    mmap[start-1][end-1] = 1
    mmap[end-1][start-1] = 1
# print(mmap)

component = []
visited = [False]*N

def bfs(start_node):
    global count
    visited[start_node]=True
    foot_prints = [start_node]
    queue = [start_node]
    while queue:
        current_node = queue.pop(0)
        for search_node in range(len(mmap[current_node])):
            if mmap[current_node][search_node] and search_node not in foot_prints:
                visited[search_node] = True
                # mmap[current_node][search_node] = 0
                # mmap[search_node][current_node] = 0
                foot_prints.append(search_node)
                queue.append(search_node)
    # return foot_prints
    count += 1

count = 0
for i in range(N):
    if visited[i]==False:
        bfs(i)
        # component.append(bfs(i))
    # prints = bfs(i)
    # prints.sort()
    # if prints not in component:
    #     component.append(prints)

# print(component)
# print(len(component))
print(count)