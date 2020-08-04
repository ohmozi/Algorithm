# 낮아지지 않는 주식가격

def solution(prices):
    leng = len(prices)
    answer = []
    for i in range(leng):
        cont = 0
        for j in range(i+1,leng):
            if prices[i] <= prices[j]:
                cont += 1
            else:
                cont += 1
                break
        answer.append(cont)
    return answer