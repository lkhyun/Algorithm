def solution(lines):
    answer = 0
    overlap = {}
    for start,end in lines:
        for i in range(start,end):
            overlap[i] = overlap.get(i,0) + 1
    keys = sorted(list(overlap.keys()))
    for key in keys:
        if overlap[key] > 1:
            answer += 1
    return answer