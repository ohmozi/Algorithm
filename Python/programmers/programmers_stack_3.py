# 우선순위가 높은 프린터

def solution(priorities, location):
    loc = [i for i in range(0, len(priorities))]
    priority = list(zip(loc, priorities))
    print(priority)
    cnt = 0
    while_check = False

    while priority:
        max =  priority[0][1]
        for_check = False

        for p in priority:      # 더 큰 우선순위가 있는지 체크
            if p[1] > max:
                for_check = True
                break

        if for_check:
            priority.append(priority.pop(0))

        else:
            temp = priority.pop(0)
            cnt += 1
            if temp[0] == location:
                while_check = True

        if while_check:
            break

    print(cnt)
    answer = cnt
    return answer