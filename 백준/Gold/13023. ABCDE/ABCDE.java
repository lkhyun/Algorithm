import java.util.*;
import java.io.*;
class Node{
    int vertex;
    Node next;

    Node(int vertex, Node next){
        this.vertex = vertex;
        this.next = next;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static Node[] adjList;
    static boolean[] visited;
    static boolean flag = false;
    
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new Node[N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to,adjList[from]);
            adjList[to] = new Node(from,adjList[to]);
        }

        for(int i=0;i<N;i++){
            visited = new boolean[N];
            if(DFS(i,0)){
                bw.write("1");
                bw.close();
                return;
            }
        }
        bw.write("0");
        bw.close();
    }
    public static boolean DFS(int cur,int depth){
        visited[cur] = true;
        if(depth == 4){
            flag = true;
            return flag;
        }

        for(Node n = adjList[cur];n != null; n = n.next){
            if(!visited[n.vertex]){
                if(DFS(n.vertex,depth+1)) return flag;
                visited[n.vertex] = false;
            }
        }
        return flag;
    }
}