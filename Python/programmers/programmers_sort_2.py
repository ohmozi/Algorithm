# 최대 숫자 만들기

def solution(numbers):
    original = list(map(str, numbers))
    # print(original)
    number = []
    for num in original:
        four_digit_num = num
        index = 0
        while len(four_digit_num) < 4:
            four_digit_num += num[index%len(num)]
            index += 1
        number.append([four_digit_num,num])
    # print(number)
    if number[-1][1] == "0":
        return "0"
    number.sort(reverse=True)
    # print(number)
    answer = ''.join(item[1] for item in number)

    return answer