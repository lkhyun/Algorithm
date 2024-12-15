def solution(arr):
    answer = []
    answer.append(arr[0])
    for a in arr:
        if answer[-1] == a:
            continue
        else:
            answer.append(a)
    return answer