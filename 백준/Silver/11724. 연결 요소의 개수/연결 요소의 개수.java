import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static List<Integer>[] adjLists;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjLists = new List[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            adjLists[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjLists[from].add(to);
            adjLists[to].add(from);
        }

        
        for(int i = 1;i<=N;i++){
            if(!visited[i]){
                BFS(i);
                cnt++;
            }
        }
        
        bw.write(cnt+"\n");

        bw.close(); 
    }
    public static void BFS(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : adjLists[cur]){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
