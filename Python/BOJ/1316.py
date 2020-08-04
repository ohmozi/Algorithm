# use flag
# a  97 ~ 122
N = int(input())
cnt = 0
for i in range(N):
    flag = True
    alpabet = [0 for _ in range(26)]
    text = input()
    before = 0
    for t in text:
        if(alpabet[ord(t)-97] == 0):
            alpabet[ord(t) - 97] = 1
            before = ord(t)
        elif(alpabet[ord(t)-97] != 0 and before != ord(t)):
            flag = False
            break

    if(flag == True):
        cnt+=1
print(cnt)