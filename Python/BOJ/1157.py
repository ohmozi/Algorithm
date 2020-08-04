# A 65~ 90
# a 97~ 122
text= input()
text = text.lower()
num_list = [0 for _ in range(26)]

for t in text:
    num_list[ord(t)-97] += 1        # 문자를 아스키코드로

cnt = 0
result = 0
for i in range(len(num_list)):
    if(num_list[i] == max(num_list)):
        cnt+=1
        result = i

if(cnt > 1):
    print('?')
else :
    print(chr(result+97).upper())