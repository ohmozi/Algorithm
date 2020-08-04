import sys
from collections import Counter         #빈도수 셀때 사용가능

N = int(sys.stdin.readline())
num_list=[]
for i in range(N):
    num_list.append(int(sys.stdin.readline()))
num_list.sort()

def mean(list):
    print(round(sum(list)/len(list)))           #round함수에 파라미터 안주면 소수첫째자리 반올림

def median(list):
    print(list[len(list)//2])

def many(list):
    list_count = Counter(list)
    list_count_many = list_count.most_common()
    if len(list)>1:             # 입력이 한개일 경우 두번째 최빈값이 없기때문에 예외처리
        if list_count_many[0][1] == list_count_many[1][1]:
            print(list_count_many[1][0])
        else:
            print(list_count_many[0][0])
    else:
        print(list_count_many[0][0])
def scope(list):
    print(list[-1]-list[0])

mean(num_list)
median(num_list)
many(num_list)
scope(num_list)