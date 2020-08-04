# 여행 경로 (공항문제)
# 테스트케이스 한개 실패

result = []

def solution(tickets):

    for i in range(len(tickets)):
        if tickets[i][0] == "ICN":
            used = [False] * len(tickets)
            used[i] = True
            dfs(tickets, tickets[i][0], tickets[i][1], used, ["ICN"])
    # for p in result:
    #     print(p)
    return sorted(result)[0]

def dfs(tickets, start, end, used, foot_prints):
    foot_prints.append(end)

    if False not in used:
        result.append(foot_prints)
        return

    else:
        for i, ticket in enumerate(tickets):
            if ticket[0] == end and not used[i]:
                used[i] = True
                dfs(tickets, ticket[0], ticket[1], used, foot_prints)

