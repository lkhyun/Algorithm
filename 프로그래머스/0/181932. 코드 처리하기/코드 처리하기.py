def solution(code):
    answer = ''
    mode = 0
    for idx in range(len(code)):
        if code[idx] == '1':
            mode ^= 1
        elif idx % 2 == mode:
            answer += code[idx]
    return answer if answer else "EMPTY"