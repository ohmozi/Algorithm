text = list(map(str,input().split(' ')))
#print(text)
cnt =0
if(text[0] == ''):
    cnt+=1
if(text[-1] == ''):
    cnt +=1
print(len(text)-cnt)