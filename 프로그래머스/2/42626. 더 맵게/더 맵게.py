import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    if scoville[0] >= K:
        return 0
    while True: 
        if len(scoville) < 2:
            return -1
        a = heapq.heappop(scoville)
        b = heapq.heappop(scoville)
        heapq.heappush(scoville,2*b+a)
        answer += 1
        if scoville[0] >= K:
            break
    return answer