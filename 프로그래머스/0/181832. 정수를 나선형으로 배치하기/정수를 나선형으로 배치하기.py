def solution(n):
    answer = [[0]*n for i in range(n)]
    i = 0
    j = 0
    num = 1
    direction = 1
    while num <= n**2:
        while 0<=i<n and answer[j][i] == 0:
            print(j,i)
            answer[j][i] = num
            num += 1
            if 0<=(i+direction)<n and answer[j][i+direction] == 0:
                i += direction
            else:
                j += direction
                break
        while 0<=j<n and answer[j][i] == 0:
            print(j,i)
            answer[j][i] = num
            num += 1
            if 0<=(j+direction)<n and answer[j+direction][i] == 0:
                j += direction
            else:
                i -= direction
                break
        direction *= -1
    return answer