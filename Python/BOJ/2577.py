A = int(input())
B = int(input())
C = int(input())
result = A*B*C
list = [0 for _ in range(10)]

while(result>0):
    list[result % 10] += 1
    result = int(result/10)
    #print(result)

for i in list:
    print(i)