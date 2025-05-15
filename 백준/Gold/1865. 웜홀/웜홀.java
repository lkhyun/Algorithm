import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int from, to, cost;
        Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M,W;
    static List<Node> road;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        loop:for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            road = new ArrayList<>();
            visited = new boolean[N+1];
            
            //일반 도로 정보
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                road.add(new Node(from, to, cost));
                road.add(new Node(to, from, cost));
            }
            //웜홀 정보
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int shrink = Integer.parseInt(st.nextToken());
                road.add(new Node(from, to, -shrink));
            }
            for (int i = 1; i <= N; i++) {
                if(!visited[i] && bellman(i)){
                    bw.write("YES\n");
                    continue loop;
                }
            }
            bw.write("NO\n");
        }
        bw.close();
    }
    public static boolean bellman(int start){
        long[] dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;
        visited[start] = true;

        for (int i = 1; i < N; i++) {
            for(Node node : road){
                if(dist[node.from] != Long.MAX_VALUE && dist[node.from] + node.cost < dist[node.to]){
                    dist[node.to] = dist[node.from] + node.cost;
                    visited[node.to] = true;
                }
            }
        }

        for(Node node : road) {
            if (dist[node.from] != Long.MAX_VALUE && dist[node.from] + node.cost < dist[node.to]) {
                return true;
            }
        }
        return false;
    }
}

