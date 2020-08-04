# 컵홀더

N = int(input())
mmap = input()

L_count = 0

for char in mmap:
    if char == 'L':
        L_count += 1
L_count /= 2

if L_count == 0:        # 커플석이 하나도 없으면 모두 컵홀더 사용가능
    print(N)
else:
    print(int(N+1-L_count))