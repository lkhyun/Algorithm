def solution(order):
    answer = 0
    digits = list(map(int,str(order)))
    answer += digits.count(3)
    answer += digits.count(6)
    answer += digits.count(9)
    return answer