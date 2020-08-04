# 97~122  string.find
result = [0 for _ in range(26)]
string = input()
for i in range(97,123):
    result[i-97] = string.find(chr(i))

for a in result:
    print(a, end=' ')

