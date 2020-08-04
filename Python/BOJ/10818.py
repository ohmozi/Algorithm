
N = map(int, input().split())
list = list(map(int, input().split(' ')))

max = list[0]
min = list[0]

for i in list:
    if max < i:
        max = i
    if min > i:
        min = i
print(min, max)
