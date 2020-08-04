import sys
N = int(sys.stdin.readline())
result=[]
for i in range(N):
    result.append(list(map(str, sys.stdin.readline().split())))

result.sort(key=lambda x: int(x[0]))
# 들어온 순서대로도 정렬해야하므로 int(x[0])으로 람다준다.  그냥 x[0]으로 하면 나이순으로 되긴하는데 이름이 무작위로 된다

# print(result)
for r in result:
    print(r[0],r[1])