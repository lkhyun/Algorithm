import java.util.*;
import java.io.*;

class Node{
    int vertex;
    int weight;
    Node next;

    Node(int vertex, int weight, Node next){
        this.vertex = vertex;
        this.weight = weight;
        this.next = next;
    }
}
public class Main {
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    static Node[] adjList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new Node[N+1]; //1부터 N까지 
        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, weight,adjList[from]);
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        dijkstra(A,B);
        bw.write(min+"");
        bw.close();
    }
    public static void dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        int[] dist = new int[N+1]; //start에서부터 모든 노드까지의 최소 거리 저장
        pq.add(new Node(start,0,null));
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.weight > dist[cur.vertex]) continue;

            for(Node n = adjList[cur.vertex]; n != null ; n=n.next){
                int newdistance = dist[cur.vertex] + n.weight;
                if(dist[n.vertex] > newdistance){
                    dist[n.vertex] = newdistance;
                    pq.add(new Node(n.vertex,newdistance,null));
                }
            }
        }
        min = dist[end];
    }
}