# 접두어 찾기
# 단순 반복
def solution(phone_book):
    phone_book.sort()
    answer = True
    for i in range(len(phone_book)):
        for j in range(i+1, len(phone_book)):
            if phone_book[i] in phone_book[j]:
                answer = False
                break
        if answer == False:
            break

    if answer :
        print("true")
    else:
        print("false")
    return answer