# 크로아티아 알파벳

croatian = ['c=','c-','d-','lj','nj','s=','z=']
# "dz="는 예외

text = input()
i = 0
count= 0
# 3,2,1순으로 확인하기

while i < len(text):
    temp = text[i:i+3]
    if temp == "dz=":
        # print("cro", temp)
        i += 3
    else:
        temp = text[i:i+2]
        if temp in croatian:
            temp = text[i:i+2]
            # print("cro",temp)
            i += 2
        else:
            temp = text[i]
            # print("not cro", temp)
            i += 1
    count += 1

print(count)