import java.util.*;
import java.io.*;

class Node{
    int from,to,weight;

    public Node(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static Node[] adjList;
    static int[] parents;
    public static void main(String[] args) throws Exception {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new Node[M];
        parents = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[i] = new Node(from, to, weight);
        }
        Arrays.sort(adjList,(a,b) -> Integer.compare(a.weight,b.weight));

        make();

        int total = 0;
        int count = 0;
        for(Node n: adjList){
            if(union(n.from,n.to)){
                total += n.weight;
                if(++count == N-1) break;
            }
        }
        bw.write(total+"");
        bw.close();
    }
    public static void make(){
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }
    public static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    public static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot==bRoot) return false;
        
        if(aRoot<bRoot){
            parents[bRoot] = aRoot;
        }else{
            parents[aRoot] = bRoot;
        }
        return true;
    }
}