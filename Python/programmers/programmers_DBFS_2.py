# 네트워크 ( 최소 연결 그래프 개수 구하기)
# BFS

count = 0

def solution(n, computers):
    visited = [False]*n

    for i in range(n):
        if visited[i] == False:
            bfs(i,visited, computers)

    return count

def bfs(start_node, visited, computers):
    global count

    visited[start_node] = True
    foot_prints = [start_node]
    queue = [start_node]
    while queue:
        current_node = queue.pop(0)
        for search_node in range(len(computers[current_node])):
            if computers[current_node][search_node] == 1 and search_node not in foot_prints:
                visited[search_node] = True
                foot_prints.append(search_node)
                queue.append(search_node)
    count += 1