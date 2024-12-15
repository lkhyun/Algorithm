import heapq
def solution(jobs):
    answer = 0
    time = 0
    waiting_queue = []
    order = []
    for i,[start,duration] in enumerate(jobs):
        order.append((start,i,duration))
    order.sort()
    while True:
        if not order:
            while waiting_queue:
                duration,start,i = heapq.heappop(waiting_queue)
                time += duration
                answer += time-start
            break
        while order:
            if order[0][0] <= time:
                heapq.heappush(waiting_queue,(order[0][2],order[0][0],order[0][1]))
                order.pop(0)
            else:
                break
        if not waiting_queue:
            time += 1
            continue
        duration,start,i = heapq.heappop(waiting_queue)
        time += duration
        answer += time-start
        
    return answer//len(jobs)