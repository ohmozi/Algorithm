# 방 번호
import math
N = input()
# print(N)
number_list = [0]*9

for char in N:
    if char =='6':
        number_list[6] += 0.5
    elif char =='9':
        number_list[6] += 0.5
    else:
        number_list[int(char)] += 1

# print(number_list)
print(math.ceil(max(number_list)))



