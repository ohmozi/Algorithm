# + - 해서 타겟넘버 만드는 방법

cnt = 0
def solution(numbers, target):

    dfs(numbers, 0, target, 0)
    return cnt

def dfs(numbers, result, target, index):
    global cnt
    if index == (len(numbers)):
        if result == target:
            cnt += 1
            return

    else :
        dfs(numbers, result-numbers[index], target, index+1)
        dfs(numbers, result+numbers[index], target, index+1)
