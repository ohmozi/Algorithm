N = int(input())
total_score = 0
score = 0
result = []
for i in range(N):
    problem = input()
    for index in problem:
        if(index == 'O'):
            score += 1
        else:
            score = 0
        total_score += score
    result.append(total_score)
    total_score=0
    score=0

for i in range(len(result)):
    print(result[i])
