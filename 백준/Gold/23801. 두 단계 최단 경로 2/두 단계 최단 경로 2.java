import java.util.*;
import java.io.*;

public class Main{
    static class Edge{
        int to;
        long weight;
        Edge(int to, long weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static List<Edge>[] adjEdges;
    static int X,Z;
    static int P;
    static long[] distStart;
    static long[] distEnd;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjEdges = new List[N+1];
        for (int i = 1; i <= N; i++) {
            adjEdges[i] = new ArrayList<>();
        }

        distStart = new long[N+1];
        distEnd = new long[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());

            adjEdges[from].add(new Edge(to, weight));
            adjEdges[to].add(new Edge(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());

        P = Integer.parseInt(br.readLine());
        List<Integer> middleVertex = new ArrayList<>(P);
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            middleVertex.add(Integer.parseInt(st.nextToken()));
        }

        dijkstra(X, distStart);
        dijkstra(Z, distEnd);

        long min = Long.MAX_VALUE;
        for (int Y : middleVertex) {
            if(distStart[Y] == Long.MAX_VALUE || distEnd[Y] == Long.MAX_VALUE) continue;  // Integer -> Long
            min = Math.min(min, distStart[Y] + distEnd[Y]);
        }
        if(min == Long.MAX_VALUE) bw.write("-1");
        else bw.write(min + "");
        bw.close();
    }
    
    public static void dijkstra(int start, long[] dist){
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> Long.compare(a.weight,b.weight));  // Integer -> Long
        Arrays.fill(dist, Long.MAX_VALUE);

        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(dist[cur.to] < cur.weight) continue;

            for (Edge next : adjEdges[cur.to]) {
                long newDistance = cur.weight + next.weight;
                if(newDistance < dist[next.to]){
                    dist[next.to] = newDistance;
                    pq.offer(new Edge(next.to, newDistance));
                }
            }
        }
    }
}