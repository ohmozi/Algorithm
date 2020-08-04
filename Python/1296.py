# 데이트

man = input()
l_man = 0
o_man = 1
v_man = 0
e_man = 0

N = int(input())
women = []
women_letter = []
love = ['L', 'O', 'V', 'E']

for _ in range(N):
    name = input()
    women.append(name)
    temp = [0]*4
    for i in range(4):
        for n in name:
            if love[i] == n:
                temp[i] += 1
    temp[1] += 1
    women_letter.append(temp)
# ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E)) mod 100
result_list = []
for i in range(N):
    result = ((women_letter[i][0] + women_letter[i][1]) * (women_letter[i][0] + women_letter[i][2]) * (women_letter[i][0] + women_letter[i][3]) * (women_letter[i][1] + women_letter[i][2]) * (women_letter[i][1] + women_letter[i][3]) * (women_letter[i][2] + women_letter[i][3])) % 100
    result_list.append(result)
    # print(result)

index_list=[]
for i in range(N):
    if result_list[i] == max(result_list):
        index_list.append(i)

answer = []
for index in index_list:
    answer.append(women[index])

answer.sort()
print(answer[0])
#
# print(women)
# print(women_letter)

