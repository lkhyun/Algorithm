import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,K;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        BFS();
        bw.flush();
        bw.close();
    }
    public static void BFS() throws Exception {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        boolean[] visited = new boolean[100001];
        pq.add(new int[]{N,0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(visited[cur[0]]){
               continue;
            }
            visited[cur[0]] = true;
            if (cur[0] == K) {
                bw.write(cur[1] + "\n");
                break;
            }
            if(cur[0]+1 <= 100000){
                pq.add(new int[]{cur[0]+1,cur[1]+1});
            }
            if(cur[0]-1 >= 0){
                pq.add(new int[]{cur[0]-1,cur[1]+1});
            }
            if(cur[0]*2 <= 100000){
                pq.add(new int[]{cur[0]*2,cur[1]});
            }
        }
    }
}