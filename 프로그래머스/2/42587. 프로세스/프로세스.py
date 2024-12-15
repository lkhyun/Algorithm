def solution(priorities, location):
    answer = 0
    while priorities:
        process = priorities.pop(0)
        if not priorities:
            answer += 1
            return answer
        if process < max(priorities):
            priorities.append(process)
            if location == 0:
                location = len(priorities)-1
            else:
                location -= 1  
        else:
            answer += 1
            if location == 0:
                return answer
            else:
                location -= 1
    return answer