def solution(progresses, speeds):
    answer = []
    num = 0
    for i in range(len(progresses)):
        if progresses[i] >= 100 or i == 0:
            num += 1
        else:
            answer.append(num)
            num = 1
        while progresses[i] < 100:
            progresses = list(map(lambda x,y: x+y, progresses,speeds))
    answer.append(num)
    return answer