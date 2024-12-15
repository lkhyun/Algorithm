def solution(answers):
    answer = []
    temp = []
    one = [1,2,3,4,5]
    two = [2,1,2,3,2,4,2,5]
    three = [3,3,1,1,2,2,4,4,5,5]
    c1 = 0
    c2 = 0
    c3 = 0
    for index in range(len(answers)):
        if one[index%5] == answers[index]:
            c1 += 1
        if two[index%8] == answers[index]:
            c2 += 1
        if three[index%10] == answers[index]:
            c3 += 1
    temp.extend([c1,c2,c3])
    maximum = max(temp)
    if maximum == c1:
        answer.append(1)
    if maximum == c2:
        answer.append(2)
    if maximum == c3:
        answer.append(3)
    return answer