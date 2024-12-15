def solution(babbling):
    answer = 0
    for word in babbling:
        i = 0
        existence = 0
        while i<len(word):
            wrong = 1
            if(existence == 0):
                if(word[i] == 'a'):
                    existence = 1
                    i += 1
                    continue
                elif(word[i] =='y'):
                    existence = 2
                    i += 1
                    continue
                elif(word[i] =='w'):
                    existence = 3
                    i += 1
                    continue
                elif(word[i] =='m'):
                    existence = 4
                    i += 1
                    continue
                else: 
                    wrong = 1
                    break
            elif(existence == 1):
                if(word[i:i+2] == "ya"):
                    i += 2
                    existence = 0
                    wrong = 0
                    continue
                else:
                    wrong = 1
                    break
            elif(existence == 2):
                if(word[i] == "e"):
                    i += 1
                    existence = 0
                    wrong = 0
                    continue
                else:
                    wrong = 1
                    break
            elif(existence == 3):
                if(word[i:i+2] == "oo"):
                    i += 2
                    existence = 0
                    wrong = 0
                    continue
                else:
                    wrong = 1
                    break
            elif(existence == 4):
                if(word[i] == "a"):
                    i += 1
                    existence = 0
                    wrong = 0
                    continue
                else:
                    wrong = 1
                    break
        if(wrong == 0):
            answer += 1
                
    return answer