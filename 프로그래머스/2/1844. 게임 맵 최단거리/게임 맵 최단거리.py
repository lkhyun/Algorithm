from collections import deque
def solution(maps):
    answer = 0
    n = len(maps)
    m = len(maps[0])
    
    q = deque()
    visited = [[False] * m for _ in range(n)]
    q.append((0,0,1))
    visited[0][0] = True
    di = [-1,1,0,0]
    dj = [0,0,-1,1]
    min = float("inf")
    while q:
        (i,j,dist) = q.popleft()
        if i==n-1 and j==m-1:
            if min > dist:
                min = dist
                continue
        for k in range(4):
            newi = i + di[k]
            newj = j + dj[k]
            if newi<0 or newi>=n or newj<0 or newj>=m or visited[newi][newj]==True or maps[newi][newj] == 0:
                continue;
            q.append((newi,newj,dist+1))
            visited[newi][newj] = True
    if min == float("inf"):
        return -1
    else:
        return min