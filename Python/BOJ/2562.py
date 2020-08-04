numbers = []
answer = 0
index = 0
for i in range(9):
    number = int(input())
    if(answer < number):
        answer = number
        index = i+1

print(answer)
print(index)
