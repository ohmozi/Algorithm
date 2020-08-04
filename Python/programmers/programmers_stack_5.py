# 완성도 100%의 기능 개발
def solution(progresses, speeds):
    answer = []

    while progresses:
        for i in range(len(progresses)):
            progresses[i] += speeds[i]
        cnt = 0
        while progresses:
            if progresses[0] > 100:
                progresses.pop(0)
                speeds.pop(0)
                cnt += 1
            else:
                break
        if cnt>0:
            answer.append(cnt)

    print(answer)

    return answer