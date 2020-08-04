# DFS와 BFS
# 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
# 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
# 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

import sys
input = sys.stdin.readline
N, M, V = map(int, input().split())
mmap = [[0] * (N+1) for _ in range(N+1)]

for i in range(M):
    start, end = map(int, input().split())
    mmap[start][end] = 1
    mmap[end][start] = 1

def dfs(current_node, mmap, foot_prints):
    foot_prints.append(current_node)
    for search_node in range(len(mmap[current_node])):
        if mmap[current_node][search_node] and search_node not in foot_prints:
            foot_prints = dfs(search_node, mmap, foot_prints)
    return foot_prints


def bfs(start_node):
    foot_prints = [start_node]
    queue = [start_node]
    while queue:
        current_node = queue.pop(0)
        for search_node in range(len(mmap[current_node])):
            if mmap[current_node][search_node] and search_node not in foot_prints:
                foot_prints.append(search_node)
                queue.append(search_node)
    return foot_prints

print(*dfs(V,mmap,[]))
print(*bfs(V))
# print(mmap)