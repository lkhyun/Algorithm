def solution(clothes):
    answer = 1
    dic = {}
    for _,kind in clothes:
        dic[kind] = ["X"]
    for c,kind in clothes:
        dic[kind].append(c)
    for key in dic.keys():
        answer *= len(dic[key])
    return answer - 1