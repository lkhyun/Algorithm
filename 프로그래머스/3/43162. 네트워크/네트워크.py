def DFS(start,graph,visited,answer):
    visited.append(start)
    
    for i in range(len(graph)):
        if i not in visited and graph[start][i]==1:
            DFS(i,graph,visited,answer)

def solution(n, computers):
    answer = 0
    visited = []
    for i in range(n):
        if i not in visited:
            DFS(i,computers,visited,answer)
            answer+=1
    return answer