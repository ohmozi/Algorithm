# N-queen
# 참고 https://rebas.kr/761
# 한열과 행에는 한개의 퀸만 놓을수있음을 이용하여 2차원배열이 아니더라도
# 행렬 3개를 이용하여 풀이가능
# 그림참고해서 이해하기
n, ans = int(input()), 0
a, b, c = [False]*n, [False]*(2*n-1), [False]*(2*n-1)

def solve(i):
    global ans
    if i == n:
        ans += 1
        return
    for j in range(n):
        if not (a[j] or b[i+j] or c[i-j+n-1]):
            a[j] = b[i+j] = c[i-j+n-1] = True
            solve(i+1)
            a[j] = b[i+j] = c[i-j+n-1] = False

solve(0)
print(ans)