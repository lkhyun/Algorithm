def solution(participant, completion):
    dic = {}
    for i in participant:
        dic[i] = dic.get(i,0) + 1
    for i in completion:
        dic[i] -= 1
    answer = [i for i in dic if dic[i] == 1]
    return answer[0]
    