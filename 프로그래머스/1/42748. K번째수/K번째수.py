def solution(array, commands):
    answer = []
    for command in commands:
        slice = array[command[0]-1:command[1]] #리스트 슬라이싱할때 뒤에는 미만이니까 -1 빼면 안된다;;
        slice.sort()
        answer.append(slice[command[2]-1])
    return answer