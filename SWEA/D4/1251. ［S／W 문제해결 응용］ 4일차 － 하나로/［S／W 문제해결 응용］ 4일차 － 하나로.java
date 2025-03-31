import java.util.*;
import java.io.*;
class Node{
    int vertex;
    double weight;

    public Node(int vertex, double weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
public class Solution {
    static int V;
    static List<Node>[] adjList; 
    static int[] xposition;
    static int[] yposition;
    static double fee;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            bw.write("#"+t+" ");
            V = Integer.parseInt(br.readLine());
            xposition = new int[V+1];
            yposition = new int[V+1];
            adjList = new ArrayList[V+1];
            visited = new boolean[V+1];

            for(int i=1;i<=V;i++){
                adjList[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine()); 
            for(int i=1;i<=V;i++){ //x 좌표 입력받기
                xposition[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=V;i++){ //y 좌표 입력받기
                yposition[i] = Integer.parseInt(st.nextToken());
            }
            fee = Double.parseDouble(br.readLine());

            for(int i=1;i<V;i++){ //간선 만들기
                for(int j=i+1;j<=V;j++){
                    double dx = xposition[i] - xposition[j];
                    double dy = yposition[i] - yposition[j];
                    double weight = (dx*dx + dy*dy) * fee;
                    adjList[i].add(new Node(j,weight));
                    adjList[j].add(new Node(i,weight));
                }
            }
            bw.write(String.format("%.0f\n",prim(1)));
        }
        bw.close();
    }
    public static double prim(int start){
        int count = 0;
        double total = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> Double.compare(a.weight, b.weight));
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.vertex]) continue;
            visited[cur.vertex] = true;
            total += cur.weight;

            if(++count == V) break;

            for(Node n: adjList[cur.vertex]){
                if(!visited[n.vertex]){
                    pq.offer(n);
                }
            }
        }
        return total;
    }
}
