# 크로스워드 만들기

word1, word2 = map(str, input().split())

# print(word1, word2)
N = len(word1)
M = len(word2)

mmap = [['.']*N for _ in range(M)]

# for m in mmap:
#     print(*m, sep='')

check = False
for i in range(len(word1)):
    for j in range(len(word2)):
        if word1[i] == word2[j]:
            loc = (i, j)
            check = True
            break
    if check == True:
        break

# print(loc)

for j in range(M):      # mmap[:][1] = word2
    mmap[j][loc[0]] = word2[j]
mmap[loc[1]] = word1

for m in mmap:
    print(*m, sep='')



