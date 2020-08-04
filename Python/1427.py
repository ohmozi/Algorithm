N = int(input())

result = []
while(N>0):
    result.append(N%10)
    N = N//10
result.sort(reverse=True)   # string으로 들어와도 int정렬 자동으로 된다.

result = map(str,result)
print("".join(result))  # list를 붙여서 출력하기

# answer = ""
# for i in result:
#     answer += i
# print(answer)