import java.util.*;
import java.io.*;

class Node{
    int vertex;//들어오는 정점
    int weight;
    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int V;
    static int E;
    static int K;
    static List<Node>[] adjLists;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        adjLists = new ArrayList[V+1];
        dist = new int[V+1];

        for(int i=1;i<=V;i++){
            adjLists[i] = new ArrayList<>();
        }

        for(int i=1;i<=E;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjLists[from].add(new Node(to,weight));
        }

        dijkstra(K);
        for(int i=1;i<=V;i++){
            if(dist[i] == Integer.MAX_VALUE){
                bw.write("INF\n");
                continue;
            }
            bw.write(dist[i]+"\n");
        }
        
        bw.close();
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight-b.weight);
        pq.offer(new Node(start,0));
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(dist[cur.vertex]<cur.weight) continue;

            for(Node n: adjLists[cur.vertex]){
                int newDistance = dist[cur.vertex] + n.weight;
                if(newDistance<dist[n.vertex]){
                    dist[n.vertex] = newDistance;
                    pq.offer(new Node(n.vertex,newDistance));
                }
            }
        }
    }
}