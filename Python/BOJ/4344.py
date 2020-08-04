N = int(input())
result = []
for i in range(N):
    cnt = 0
    scores = list(map(int, input().split()))
    avg_score = sum(scores[1:]) / scores[0]         # 첫번째 개수를 나타내는 정수는 의미 없으니 제외
    for j in scores[1:]:
        if(j> avg_score):
            cnt += 1
    result.append("%0.3f"%round(cnt/scores[0]*100,3))       # 소수 3자리 까지 반올림 표현

for i in result:
    print('%s%%'%i)
    # %기호를 쓸때 두번 쓰기