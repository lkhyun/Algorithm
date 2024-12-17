def solution(l, r):
    answer = []
    fivelist = [int(str(bin(i))[2:])*5 for i in range(1,64)]
    
    for i in fivelist:
        if l <= i <= r:
            answer.append(i)
    return answer if answer else [-1]