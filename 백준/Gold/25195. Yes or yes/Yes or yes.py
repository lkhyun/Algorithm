def bfs():
    N,M = map(int,input().split())
    matrix = [[] for _ in range(N+1)]
    for _ in range(M):
        start,end = map(int,input().split(' '))
        matrix[start].append(end)
        
    fan_numbers = int(input())
    fan_nodes = list(map(int,input().split(' ')))
    
    queue = []
    visit = [0 for _ in range(N+1)]
    if 1 in fan_nodes:
        print("Yes")
        return
    queue.append(1)
    visit[1] = 1
    flag = 0
    while queue:
        node = queue.pop(0)
        if not matrix[node]:
            print("yes")
            return
        for i in matrix[node]:
            if visit[i] == 0:
                visit[i] = 1
                if i in fan_nodes:
                    continue
                queue.append(i)
    print("Yes")
bfs()