import sys
N = int(sys.stdin.readline())
text=[]
for _ in range(N):
    text.append(input())
text= list(set(text))
text.sort(key=lambda x: (len(x), x))
# print(text)
for t in text:
    print(t)