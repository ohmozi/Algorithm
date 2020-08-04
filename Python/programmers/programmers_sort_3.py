# 논문 인용점수
# ??문제 이해 못함

def solution(citations):
    result = []
    mmax = max(citations)
    for m in range(mmax,0,-1):
        count = 1
        for i in range(len(citations)):
            if m <= citations[i]:
                count += 1
        if count >= m:
            result.append(m)
    print(result)
    result.sort()
    answer = result[-1]
    return answer