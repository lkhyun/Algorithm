import java.util.*;
import java.io.*;

class Node{
    int number;
    Node next;

    Node(int number, Node next){
        this.number = number;
        this.next = next;
    }
}

public class Main {
    static int N;
    static int M;
    static Node[] adjNodes;
    static int[] degrees;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjNodes = new Node[N+1];
        degrees = new int[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjNodes[from] = new Node(to, adjNodes[from]);
            degrees[to]++;
        }
        makeLine();
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                bw.write(i+" ");
            }
        }
        bw.close();
    }

    public static void makeLine() throws Exception{
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(degrees[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            bw.write(cur+" ");
            visited[cur] = true;
            for(Node n = adjNodes[cur]; n != null; n = n.next){
                if(--degrees[n.number] == 0){
                    q.add(n.number);
                }
            }
        }
    }
}
