def solution(s):
    answer = True
    stk = []
    for i in s:
        if i == '(':
            stk.append('(')
        else:
            if len(stk) != 0:
                stk.pop()
            else:
                return False
    
    if len(stk) == 0:
        return True
    else:
        return False