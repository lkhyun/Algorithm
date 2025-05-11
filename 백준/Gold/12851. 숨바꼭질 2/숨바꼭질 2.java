import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS();
        bw.write(min+"\n"+cnt);
        bw.close();
    }
    public static void BFS() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        q.offer(new int[]{N,0});
        visited[N] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]] = true;
            if(cur[0] == K){
                if(cur[1]<min){
                    cnt = 1;
                    min = cur[1];
                }else if(cur[1]==min){
                    cnt++;
                }
                continue;
            }

            int next = cur[0]-1;
            if(next>=0 && next<=100000 && !visited[next]){
                q.offer(new int[]{next,cur[1]+1});
            }

            next = cur[0]+1;
            if(next>=0 && next<=100000 && !visited[next]){
                q.offer(new int[]{next,cur[1]+1});
            }

            next = cur[0]*2;
            if(next>=0 && next<=100000 && !visited[next]){
                q.offer(new int[]{next,cur[1]+1});
            }
        }

    }
}
