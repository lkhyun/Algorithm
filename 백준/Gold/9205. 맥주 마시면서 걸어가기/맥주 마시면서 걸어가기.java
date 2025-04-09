import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int i,j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static Node start;
    static Node end;
    static Node[] adjList;
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            adjList = new Node[N+1];

            st = new StringTokenizer(br.readLine());
            start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                int tempi = Integer.parseInt(st.nextToken());
                int tempj = Integer.parseInt(st.nextToken());
                adjList[i] = new Node(tempi,tempj);
            }

            st = new StringTokenizer(br.readLine());
            end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            adjList[N] = end;

            if(BFS()){
                bw.write("happy\n");
            }else{
                bw.write("sad\n");
            }
        }
        bw.close(); 
    }
    public static boolean BFS(){
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        q.add(start);

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int k=0;k<=N;k++){
                Node next = adjList[k];
                if(!visited[k]){
                    int dist = Math.abs(cur.i-next.i) + Math.abs(cur.j-next.j);
                    if(dist<=1000){
                        if(next == end) return true;
                        q.add(next);
                        visited[k] = true;
                    }
                }
            }
        }
        return false;
    }
}

