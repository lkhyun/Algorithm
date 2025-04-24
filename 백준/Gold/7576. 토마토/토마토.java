import java.io.*;
import java.util.*;

public class Main {

    static int M,N;
    static int[][] box;
    static ArrayDeque<int[]> q;
    static boolean[][] visited;
    static int days;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        q = new ArrayDeque<>();
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    q.add(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }

        days = 0;
        if(BFS()){
            bw.write(days + "\n");
        }else{
            bw.write("-1\n");
        }
        bw.close();
    }
    public static boolean BFS(){
        int[] di = {0,0,-1,1};
        int[] dj = {-1,1,0,0};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            days = Math.max(days,cur[2]);
            for (int i = 0; i < 4; i++) {
                int[] next = new int[3];
                next[0] = cur[0] + di[i];
                next[1] = cur[1] + dj[i];
                next[2] = cur[2] + 1;
                if(next[0]<0 || next[0]>=N || next[1]<0 || next[1]>=M || visited[next[0]][next[1]]){
                    continue;
                }
                if(box[next[0]][next[1]] == -1){
                    continue;
                }
                q.add(next);
                visited[next[0]][next[1]] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && box[i][j] != -1){
                    return false;
                }
            }
        }
        return true;
    }
}
