N  = int(input())
for i in range(N):
    num, string = input().split()
    text = ''
    for t in string:
        text += int(num)*t
    print(text)
