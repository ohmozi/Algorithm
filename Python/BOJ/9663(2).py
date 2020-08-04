
n=int(input())

chessboard=[[0 for _ in range(n)] for _ in range(n)]
count=0

def check(x,y):
    #같은열에 퀸이 있는지 확인
    for i in range(x):
        if chessboard[i][y]==1:
            return 0

    #좌 상단 대각선에 퀸이 있는지 확인
    leftrow=x
    leftcol=y
    while leftrow>=0 and leftcol>=0:
        if chessboard[leftrow][leftcol]:
            return 0
        leftrow-=1
        leftcol-=1

    #우 상단 대각선에 퀸이 있는지 확인
    rightrow=x
    rightcol=y
    while rightrow>=0 and rightcol<n:
        if chessboard[rightrow][rightcol]==1:
            return 0
        rightrow-=1
        rightcol+=1

    return 1



def dfs(x):
    if x==n:
        global count
        count+=1
        return

    for i in range(n):
        if check(x,i):#끝까지 도달하면
            chessboard[x][i]=1
            dfs(x+1)
            chessboard[x][i]=0


dfs(0)#0줄부터 시작
print(count)