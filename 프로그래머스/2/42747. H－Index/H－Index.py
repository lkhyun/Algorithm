def solution(citations):
    answer = 0
    citations.sort()
    for i in range(1,len(citations)+1):
        if citations[-i] <= i:
            return max(citations[-i],i-1)
        
    return len(citations)