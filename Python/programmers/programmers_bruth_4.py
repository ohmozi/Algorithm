# 노란 카펫을 둘러싼 갈색 카펫
# easy

def solution(brown, yellow):
    # 가로 세로는 3이상일수밖에 없을듯
    # 합을 만들수 있는 곱의 순서쌍 구하기
    total = brown + yellow
    bucket = []
    for a in range(3,total):
        if total % a == 0:
            if total/a < a:
                break
            bucket.append([total//a, a])

    for item in bucket:
        if ((item[0]-2) * (item[1]-2)) == yellow:
            answer = item
            break

    return answer