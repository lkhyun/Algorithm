import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int to,cost;
        Node(int to,int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static List<Node>[] adjList;
    static int[] dist;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to,cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        prev = new int[N+1];
        dijkstra(start);

        bw.write(dist[end]+"\n");
        List<Integer> l = new ArrayList<>();
        int tmp = end;
        while(tmp != 0){
            l.add(tmp);
            tmp = prev[tmp];
        }
        bw.write(l.size()+"\n");
        for(int i=l.size()-1;i>=0;i--){
            bw.write(l.get(i)+" ");
        }

        bw.close();
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.offer(new Node(start,0));
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost > dist[cur.to]) continue;

            for (Node next : adjList[cur.to]) {
                int newdist = dist[cur.to] + next.cost;
                if(newdist < dist[next.to]){
                    dist[next.to] = newdist;
                    prev[next.to] = cur.to;
                    pq.offer(new Node(next.to,newdist));
                }
            }
        }
    }
}
