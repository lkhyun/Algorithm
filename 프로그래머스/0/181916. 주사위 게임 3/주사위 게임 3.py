def solution(a, b, c, d):
    answer = 0
    original = [a,b,c,d]
    same = set(original)
    if len(same) == 4:
        answer = min([a,b,c,d])
    elif len(same) == 3:
        p = 0
        seen = set()
        for i in original:
            if i in seen:
                p = i
                break
            else:
                seen.add(i)
        same.remove(p)
        same = list(same)
        answer = same[0]*same[1]
    elif len(same) == 2:
        p = 0
        p_count = 1
        seen = set()
        for i in original:
            if i in seen:
                if p_count == 1:
                    p = i
                    p_count += 1
                else:
                    if p == i:
                        p_count += 1
            else:
                seen.add(i)
        same = list(same)
        print(p_count)
        if p_count == 2:
            answer = (same[0]+same[1])*(abs(same[0]-same[1]))
        else:
            same.remove(p)
            answer = ((10*p)+same[0])**2
    else:
        answer = 1111*a
        
    return answer