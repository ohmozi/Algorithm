# 주어진 카드로 가능한 소수조합찾기
# 스트링을 바로 리스트로 변경
# permutation과 set을 활용

from itertools import permutations
import math

def isPrime(number):
    stop = int(math.sqrt(number))

    if number <2:
        return False

    else:
        for i in range(2, stop+1):
            if number % i ==0:
                # print(number)
                return False

    return True

def solution(numbers):
    result = []
    for k in range(1,len(numbers)+1):
        perm = list(map(''.join,  permutations(list(numbers),k)))
        perm_set = set(perm)

        for n in perm_set:
            if isPrime(int(n)):
                result.append(int(n))

    # print(set(result))
    answer = len(set(result))
    return answer