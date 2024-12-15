def solution(bridge_length, weight, truck_weights):
    time = 0
    current_weight = 0
    queue = [0 for _ in range(bridge_length)]
    for truck in truck_weights:
        time += 1
        if current_weight + truck <= weight:
            queue.append(truck)
            current_weight -= queue.pop(0)
            current_weight += truck
            continue
        else:
            current_weight -= queue.pop(0)
            while current_weight + truck > weight:
                queue.append(0)
                time += 1
                current_weight -= queue.pop(0)
            queue.append(truck)
            current_weight += truck
                
    return time + bridge_length