import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int to,cost;
        Node(int to,int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M,X;
    static List<Node>[] graph;
    static int[] backRoute;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,cost));
        }
        //돌아가는 길 구하기
        backRoute = new int[N+1];
        Arrays.fill(backRoute,Integer.MAX_VALUE);
        dijkstra(X,backRoute);

        //파티 지점까지 가는 길 각각 구하기
        for (int i = 1; i <= N; i++) {
            int[] dist = new int[N+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dijkstra(i,dist);
            max = Math.max(max,dist[X] + backRoute[i]);
        }
        bw.write(max+"\n");
        bw.close();
    }
    public static void dijkstra(int start,int[] dist){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.to] < cur.cost) continue;

            for (Node next : graph[cur.to]) {
                int newDistance = dist[cur.to] + next.cost;
                if (newDistance < dist[next.to]) {
                    dist[next.to] = newDistance;
                    pq.add(new Node(next.to, newDistance));
                }
            }
        }
    }
}

