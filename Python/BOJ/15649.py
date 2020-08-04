N, M = map(int, input().split())
check = [False for _ in range(N+1)]
result = [0 for _ in range(M)]

def find1(index,N,M):
    if index == M:
        for i in range(M):
            print(result[i],end=' ')
        print()
        return
    else:
        for i in range(1, N+1):
            if check[i]:
                continue
            check[i]=True
            # print("i: " ,i)
            result[index]=i
            # print("index: ", index)
            find1(index+1, N, M)
            check[i]=False

find1(0,N,M)
print("-------------------")

def find2(index, start, N,M):
    if index == M:
        for i in range(M):
            print(result[i],end=' ')
        print()
        return
    for i in range(start, N+1):
        if check[i]:
            continue
        check[i]=True
        result[index]=i
        find2(index+1, i+1, N, M)
        check[i]=False
find2(0,1,N,M)
print("--------------")
def find3(index, N,M):
    if index == M:
        for i in range(M):
            print(result[i],end=' ')
        print()
        return
    for i in range(1, N+1):
        result[index]=i
        find3(index+1, N, M)
find3(0,N,M)

print("-------------------")

def find4(index, start, N,M):
    if index == M:
        for i in range(M):
            print(result[i],end=' ')
        print()
        return
    for i in range(start, N+1):
        result[index]=i
        find4(index+1, i, N, M)

find4(0,1,N,M)