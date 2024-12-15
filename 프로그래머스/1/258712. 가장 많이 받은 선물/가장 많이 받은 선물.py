def solution(friends, gifts):
    answer = 0
    count = 0
    table = {}
    give_present_index = {}
    take_present_index = {}
    for gift in gifts:
        items = gift.split(" ")
        A = items[0]
        B = items[1]
        
        give_present_index[A] = give_present_index.get(A,0) + 1
        take_present_index[B] = take_present_index.get(B,0) + 1
        
        if A not in table:
            table[A] = {}
        if B not in table:
            table[B] = {}

        table[A][B] = table[A].get(B, 0) + 1
    
    
    for friend in friends:
        count = 0
        for other in friends:
            if friend == other:
                continue

            if friend in table and other in table:
                if table[friend].get(other,0) > table[other].get(friend, 0):
                    count += 1
                elif table[friend].get(other,0) == table[other].get(friend, 0):
                    if (give_present_index.get(friend,0) - take_present_index.get(friend,0)) > (give_present_index.get(other,0) - take_present_index.get(other,0)):
                        count += 1
            else:
                if (give_present_index.get(friend,0) - take_present_index.get(friend,0)) > (give_present_index.get(other,0) - take_present_index.get(other,0)):
                    count += 1
        
        answer = max(answer, count)

    return answer