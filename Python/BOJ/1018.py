# 체스판 다시 칠하기
# 참고 X
# 140ms
# import sys
N, M = map(int, input().split())
board=[]
result =[]
# sol = sys.maxsize
for i in range(N):
    board.append(str(input()))

for x in range(N-8+1):
    for y in range(M-8+1):
        num1, num2 =0,0
        # 'W'
        for a in range(8):
            if a%2==0:
                for b in range(8):
                    if b%2==0:
                        if board[x+a][y+b] == 'B':
                            num1 += 1
                    else:
                        if board[x+a][y+b] == 'W':
                            num1 += 1
            else:
                for b in range(8):
                    if b%2==1:
                        if board[x+a][y+b] == 'B':
                            num1 += 1
                    else:
                        if board[x+a][y+b] == 'W':
                            num1 += 1
        # 'B'
        for a in range(8):
            if a % 2 == 0:
                for b in range(8):
                    if b % 2 == 0:
                        if board[x + a][y + b] == 'W':
                            num2 += 1
                    else:
                        if board[x + a][y + b] == 'B':
                            num2 += 1
            else:
                for b in range(8):
                    if b % 2 == 1:
                        if board[x + a][y + b] == 'W':
                            num2 += 1
                    else:
                        if board[x + a][y + b] == 'B':
                            num2 += 1
        result.append(min(num1, num2))
# print(result)
print(min(result))