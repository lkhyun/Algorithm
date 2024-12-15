def solution(n, lost, reserve): #lost나 reserve를 이용해서 반복문을 돌고 있는 와중에 원소를 제거하면 뭔가 꼬이나바 조심!
    answer = 0
    new_lost = [i for i in lost if i not in reserve] #이렇게 해야하는 이유는 같은 원소들끼리 만나서 제거되기 전에 빌려줘                                                         버리면 문제가 생기더라구
    new_reserve = [i for i in reserve if i not in lost]
    new_lost.sort()
    new_reserve.sort()
    for l in new_lost[:]: #그래서 이런식으로 리스트 전체를 복사한 것을 저렇게 사용가능
        if l-1 in new_reserve:
            new_lost.remove(l)
            new_reserve.remove(l-1)
        elif l+1 in new_reserve:
            new_lost.remove(l)
            new_reserve.remove(l+1)
    answer = n - len(new_lost)
    return answer