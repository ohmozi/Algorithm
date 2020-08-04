# 큐를 이용한 단순 구현, 리팩토링 필요
def solution(bridge_length, weight, truck_weights):
    time = 0
    passing_truck = [] # 건너는 큐
    # print(truck_weights)

    while truck_weights:    # 대기 트럭과 다리를 건너는 트럭의 대기가 없어질 때 까지
        pass_sum = 0
        time += 1


        if len(passing_truck):
            if passing_truck[0][1] == bridge_length:        # 거리카운트가 다리를 지났으면 큐에서 제거
                passing_truck.pop(0)
        for truck in passing_truck:     # 지나가는 트럭들의 무게 합
            pass_sum += truck[0]
        # print(pass_sum + truck_weights[0])
        if ((pass_sum + truck_weights[0]) <= weight):
            # print("pass_sum : {}, waiting : {}".format(pass_sum, truck_weights))
            passing_truck.append([truck_weights.pop(0),0])


        for truck in passing_truck:
            truck[1] += 1
        # print("time {} , passing {} , wait {}".format(time, passing_truck, truck_weights))

    # print(passing_truck[-1][1])
    #     while passing_truck:
    #         if passing_truck[0][1] == bridge_length:        # 거리카운트가 다리를 지났으면 큐에서 제거
    #             passing_truck.pop(0)

    #         for truck in passing_truck:
    #             truck[1] += 1
    #         time += 1

    # 거리 카운트를 같이 넣어줘야할듯?
    # 큐와 새로 들어가는 트럭의 무게가 견딜수있는 weight보다 큰지 확인

    answer = time + bridge_length
    return answer