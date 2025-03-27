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
public class Solution {
    static int V;
    static int E;
    static Node[] adjList; 
    static int[] parents;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            bw.write("#"+t+" ");
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            parents = new int[V+1];
            adjList = new Node[E];
           
            for(int i=0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                adjList[i] = new Node(from,to,weight);
            }

            Arrays.sort(adjList,(a,b) -> a.weight - b.weight);
            make();
            
            long total = 0;
            int count = 0;
            for(int i = 0;i<E;i++){
                if(union(adjList[i].from, adjList[i].to)){
                    total += adjList[i].weight;
                    if(++count == V-1) break;
                }
            }
            bw.write(total+"\n");
        }
        bw.close();
    }
    public static void make(){
        for(int i=1;i<=V;i++){
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

        if(aRoot == bRoot) return false;
        else{
            if(aRoot<bRoot) parents[bRoot] = aRoot;
            else parents[aRoot] = bRoot;
        }
        return true;
    }
    
}
