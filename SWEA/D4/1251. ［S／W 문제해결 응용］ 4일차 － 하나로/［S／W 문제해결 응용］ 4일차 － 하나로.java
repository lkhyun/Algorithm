import java.util.*;
import java.io.*;
class Node{
    int from,to;
    double weight;

    public Node(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
public class Solution {
    static int V;
    static List<Node> adjList; 
    static int[] parents;
    static int[] xposition;
    static int[] yposition;
    static double fee;

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
            parents = new int[V+1];
            adjList = new ArrayList<>();

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
                    adjList.add(new Node(i,j,weight));
                }
            }
            Collections.sort(adjList,(a,b) -> Double.compare(a.weight,b.weight));
            make();
            
            double total = 0;
            int count = 0;
            for(Node n : adjList){
                if(union(n.from,n.to)){
                    total += n.weight;
                    if(++count == V-1) break;
                }
            }
            bw.write(String.format("%.0f\n",total));
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
