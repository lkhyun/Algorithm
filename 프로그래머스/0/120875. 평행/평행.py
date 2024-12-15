def solution(dots):
    answer = 0
    result1 = []
    result2 = []
    i = 0
    while i < 3:
        j = i+1
        while j < 4:
            if(i == 0):
                result1.append((dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]))
            else:
                result2.append((dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]))
            j+=1
        i+=1
    result2.reverse()
    print(result1)
    print(result2)
    result = [1 if x==y else 0 for x,y in zip(result1,result2)]
    if(result.count(1)>0):
        return 1
    else:
        return 0