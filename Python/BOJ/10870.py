def fibo(n):
    if n==0:
        return 1
    elif n==1:
        return 1
    return fibo(n-1)+fibo(n-2)

N = int(input())
if N==0:
    print('0')
else:
    print(fibo(N-1))