import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int to,cost;
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int V;
    static List<Node>[] graph;
    static int max;
    static int destination;

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int to;
            while ((to = Integer.parseInt(st.nextToken())) != -1) {
                int cost = Integer.parseInt(st.nextToken());
                graph[vertex].add(new Node(to, cost));
                graph[to].add(new Node(vertex, cost));
            }
        }
        BFS(1);
        max = 0;
        BFS(destination);
        bw.write(max + "");
        bw.close();
    }
    public static void BFS(int start){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[V + 1];
        q.offer(new int[]{start,0});
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[1]>max){
                max = cur[1];
                destination = cur[0];
            }
            for(Node n : graph[cur[0]]){
                if(visited[n.to]) continue;
                q.offer(new int[]{n.to,cur[1]+n.cost});
                visited[n.to] = true;
            }
        }
    }
}

