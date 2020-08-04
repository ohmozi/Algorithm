# 민균이의 비밀번호

N = int(input())
strings = []
for _ in range(N):
    strings.append(input())
# print(strings)

for i in range(N):
    for j in range(i,N):        # 자기 자신이 대칭일 때를 위해 i+1이 아님
        if len(strings[i]) == len(strings[j]) and strings[i][::-1] == strings[j]:
            print(len(strings[i]), strings[i][len(strings[i])//2])
