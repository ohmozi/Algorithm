# 배고픈 마라토너

import sys
input = sys.stdin.readline
N = int(input())
mara = dict()

for i in range(2*N-1):
    name = input().strip()
    #print(name in mara)
    try:
        del mara[name]
    except:
        mara[name] = 1


print("".join(list(mara.keys())))