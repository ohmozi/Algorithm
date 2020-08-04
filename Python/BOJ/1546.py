N = int(input())
total = 0
max = 0
list = list(map(int, input().split(' ')))
for i in list:
    if( max < i):
        max = i
    total += i
print(round(100/max*total/N, 2))