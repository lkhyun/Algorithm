import java.util.*;
import java.io.*;

public class Solution {
    static boolean[][] graph;
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int t = 1;t<=10;t++){
            graph = new boolean[101][101];
            st = new StringTokenizer(br.readLine());
            int adjCount = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<adjCount/2;i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from][to] = true;
            }
            bw.write("#"+t+" "+BFS(start)+"\n");
        }
        bw.close();
    }
    public static int BFS(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayDeque<Integer> prevq = new ArrayDeque<>();
        boolean[] visited = new boolean[101];
        q.add(start);
        visited[start] = true;
        int currentqsize = 1;

        while(!q.isEmpty()){
            prevq.clear();

            for(int k=0;k<currentqsize;k++){
                int cur = q.poll();
                prevq.add(cur);

                for(int i=1;i<=100;i++){
                    if(graph[cur][i]&&!visited[i]){
                        q.add(i);
                        visited[i] = true;
                    }
                }
            }
            currentqsize = q.size();
        }

        int max = 0;
        while(!prevq.isEmpty()){
            max = Math.max(max,prevq.poll());
        }
        return max;
    }
}
