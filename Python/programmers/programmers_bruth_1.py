# 모의고사 찍을 때 최대점수 구하기

def solution(answers):
    student = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]]
    student_score = []

    for i, who in enumerate(student):
        score = 0
        for a in range(len(answers)):
            if answers[a] == who[a%len(who)]:
                score +=1
        student_score.append([score,i+1])

    print(student_score)
    student_score.sort()
    mmax = student_score[-1][0]
    answer = []
    for i in student_score:
        if mmax == i[0]:
            answer.append(i[1])
    answer.sort()
    return answer