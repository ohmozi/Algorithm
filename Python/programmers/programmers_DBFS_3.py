# 단어 변환
# DFS

result = []

def solution(begin, target, words):
    visited = [False] * len(words)

    if target not in words:     # 단어가 존재하지 않으면 return 0
        return 0

    dfs(begin, target, words, 0, visited)       # dfs 실행

    answer = min(result)        # 각 단계중 최소 값을 답으로 선택
    return answer

def dfs(begin, target, words, count, visited):
    if begin == target:             # target에 도착하면 카운트 값 저장하고 리턴
        result.append(count)
        return

    else:
        for i, word in enumerate(words):            # words 리스트 확인
            differ = 0
            for j in range(len(begin)):             # 단어 중 하나의 알파벳만 다른 경우 찾기
                if begin[j] != word[j]:
                    differ += 1
            if differ == 1 and not visited[i]:     # 다른게 하나고 풋프린트에 없으면 가능
                visited[i] = True                   # 방문했음
                # print(word, "->", end="")
                dfs(word, target, words, count+1, visited)      # dfs
                visited[i] = False                  # 다른 조합을 위해 방금 방문한거 풀어주기
                # print()