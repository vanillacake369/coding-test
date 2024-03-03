from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0

    bridge = deque([0] * bridge_length)
    trucks = deque(truck_weights)

    currentWeight = 0
    while len(trucks) != 0:
        answer += 1
        currentWeight -= bridge.popleft()
        if (currentWeight + trucks[0] <= weight):
            currentWeight += truck_weights[0]
            bridge.append(trucks.popleft())
        else:
            bridge.append(0)

    answer += bridge_length

    return answer
