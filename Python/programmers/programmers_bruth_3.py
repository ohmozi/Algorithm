# 숫자야구
# ball counting에 set활용하는 기법 기억하기

from itertools import permutations

def check_con(baseball, number):
    check = True
    for con in baseball:
        strike = 0
        # con [123,1,1]
        for i in range(3):
            # 스트라이크 카운트
            if number[i] == str(con[0])[i]:
                strike += 1
        # ball 카운트
        ball = len(set(str(con[0])) & set(number))-strike

        if ball != con[2] or strike != con[1]:
            check = False
            break
    return check

def solution(baseball):
    answer = 0
    numbers = [ str(i) for i in range(1,10)]
    perm = list(map(''.join, permutations(numbers,3)))

    for i in perm:
        if check_con(baseball, i) :
            answer += 1
    # print(check_con(baseball, "324"))
    # print(check_con(baseball, "328"))
    # find함수로 참이면 볼 카운트
    # 3자리 비교해서 스트라이크개수
    # 스트라이크 개수에 따라 조합확인

    # 완전 브루트포스는 123~987 대충 900개를 100개에 대해서 90000 할만함
    # 스트라이크 + 볼 개수 가장 많은 조합을 먼저 찾은다음에 조합수를 줄이는건?
    return answer