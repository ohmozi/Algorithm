# 왼쪽으로 높은 송신탑

def solution(heights):
    print(heights)
    answer = [0]
    for i in range(1,len(heights)):
        check = False
        for j in range(i-1,-1,-1):
            if heights[i]< heights[j]:
                check = True
                answer.append(j+1)
                break
        if not check :
            answer.append(0)
    print(answer)
    return answer