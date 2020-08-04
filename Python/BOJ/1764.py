# 듣보잡
N, M = map(int,input().split())
hear = set()
see = set()
for _ in range(N):
    hear.add(input())

for _ in range(M):
    see.add(input())

dup = list(hear&see)
print(len(dup))
for text in sorted(dup):
    print(text)
# cnt = 0
# if len(hear)< len(see):
#     for text in hear:
#         for i in range(len(see)):
#             if text == see[i]:
#                 cnt += 1
#                 del see[i]          # del이 삭제가 제대로 되는건가 확인하기
#                 break
# else:
#     for text in see:
#         for i in range(len(hear)):
#             if text == hear[i]:
#                 cnt += 1
#                 del hear[i]
#                 break
# print(cnt)