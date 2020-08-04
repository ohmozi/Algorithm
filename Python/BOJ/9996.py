# 한국이 그리울땐 서버에 접속하지

N = int(input())
pattern = input()

pat = pattern.split("*")
prefix, suffix  = pat[0], pat[1]

# print(prefix, suffix)
str_list=[]
for _ in range(N):
    str_list.append(input())

for i in range(N):

    if str_list[i][:len(prefix)] == prefix and str_list[i][-len(suffix):] == suffix:
        if len(str_list[i]) >= len(pattern)-1:          # ab*ba일때  aba도 처리해야됨
            print("DA")
        else:
            print("NE")
    else:
        print("NE")

# error
# 3
# ab*ba
# ababbaba
# abdfsddf
# aba
# DA
# NE
# DA