def solution(N, number):
    answer = 0
    if N == number:
        return 1
    
    dp = [set() for _ in range(8)] #8번까지만 셀거니까
    for i in range(6):
        dp[i].add(int(str(N)*(i+1))) # ex N,NN,NNN,NNNN,NNNNN,NNNNNN
    
    for i in range(1,8): # dp[0]이 1번 사용한거니까 어차피 연산할 필요없음 그래서 2번 연산부터 하려고 dp[1]부터 시작
        for j in range(i): #dp[1]에 dp[0]중 하나랑 dp[0]중 하나랑 연산한거 넣어야지 dp[2]는 dp[0],dp[1]하고 dp[1],dp[0]넣어야지
            for x in dp[i-j-1]:
                for y in dp[j]:
                    dp[i].add(x+y)
                    dp[i].add(x-y)
                    dp[i].add(x*y)
                    if y != 0:
                        dp[i].add(x/y)
                        
        if number in dp[i]:
            return i+1
    return -1