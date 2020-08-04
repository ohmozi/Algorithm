# collection을 활용하여 딕셔너리 개수 세기 

import collections

p = ['mislav', 'stanko', 'mislav', 'ana']
c = ['stanko', 'ana', 'mislav']

def solution(participant, completion):

    print(collections.Counter(p))
    print(collections.Counter(c))
    print(collections.Counter(p)-collections.Counter(c))
    answer = ''
    return answer

solution(p,c)