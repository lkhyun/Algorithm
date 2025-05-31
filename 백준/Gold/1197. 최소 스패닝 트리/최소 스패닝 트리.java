import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int V,E;
    static PriorityQueue<int[]> edgeList;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        parent = new int[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeList.add(new int[]{u,v,w});
        }
        init();

        int treeWeight = 0;
        while (!edgeList.isEmpty()) {
            int[] edge = edgeList.poll();
            if (merge(edge[0], edge[1])) {
                treeWeight += edge[2];
            }
        }
        bw.write(treeWeight+"\n");
        bw.close();
    }
    public static void init(){
        for (int i = 1; i <= V ; i++) {
            parent[i] = i;
        }
    }
    public static int find(int cur){
        if(parent[cur] == cur){
            return cur;
        }else{
            return parent[cur] = find(parent[cur]);
        }
    }
    public static boolean merge(int u, int v){
        int rootU = find(u);
        int rootV = find(v);
        if(rootU < rootV){
            parent[rootV] = rootU;
            return true;
        }else if(rootU > rootV){
            parent[rootU] = rootV;
            return true;
        }else{
            return false;
        }
    }
}
