import java.util.*;
import java.io.*;

public class Solution{
    static class Edge{
        int u,v,weight;
        Edge(int u, int v, int weight){
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static int[] parent;
    static List<Edge> l;
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int ans = 0;
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            l = new ArrayList<>();

            for (int j = 1; j <= N; j++) {
                parent[j]= j;
            }

            for (int j = 0; j < M; j++) {
               st = new StringTokenizer(br.readLine());
               int u = Integer.parseInt(st.nextToken());
               int v = Integer.parseInt(st.nextToken());
               int weight = Integer.parseInt(st.nextToken());
               l.add(new Edge(u, v, weight));
            }
            l.sort((a,b) -> a.weight - b.weight);

            for(Edge e:l){
                if(merge(e.u, e.v)){
                    ans += e.weight;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(i).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.close();
    }
    static int find(int cur){
        if(parent[cur] == cur){
            return cur;
        }else{
            return parent[cur] = find(parent[cur]);
        }
    }
    static boolean merge(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot){
            return false;
        }
        if(aRoot < bRoot){
            parent[bRoot] = aRoot;
        }else{
            parent[aRoot] = bRoot;
        }
        return true;
    }
}