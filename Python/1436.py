# 영화감독 숌
# 참고 O  'in'사용하기
# 820ms
# 666 1666 2666 3666 4666 5666 6660 6661 ... 6669 7666 8666 9666 / 10666 11666 12666 13666 14666 15666 16660 16661 ... 16669 17666 18666 19666 / 20666
# 9 + 10 / (9 + 10)*9
import sys
input = sys.stdin.readline
N = int(input())

number = 666
cnt = 0
while 1:
    if "666" in str(number):
        cnt += 1
        if cnt ==N:
            break
    number += 1

print(number)