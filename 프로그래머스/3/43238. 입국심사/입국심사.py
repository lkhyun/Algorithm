def solution(n, times):
    answer = 0
    left = 1
    right = max(times)*n
    while left < right:
        capacity = 0
        mid = (left + right) // 2
        for time in times:
            capacity += mid // time
            if capacity >= n:
                break
                
        if capacity >= n:
            answer = mid
            right = mid
        elif capacity < n:
            left = mid + 1
        
    return answer