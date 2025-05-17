import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static int[][] matrix;
    static int cnt = 0;
    static int[] di = {0,0,-1,1};
    static int[] dj = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(BFS()){
            cnt++;
        }

        bw.write(cnt+"");
        bw.close();
    }
    public static boolean BFS(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int ni = cur[0]+di[k];
                int nj = cur[1]+dj[k];
                if(ni<0||ni>=N||nj<0||nj>=M) continue;

                if(matrix[ni][nj] == 0){
                    if(!visited[ni][nj]){
                        q.offer(new int[]{ni,nj});
                        visited[ni][nj] = true;
                    }
                }else{
                    matrix[ni][nj]++;
                }
            }
        }
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j] >= 3){
                    matrix[i][j] = 0;
                    flag = true;
                }else if(matrix[i][j] == 2){
                    matrix[i][j] = 1;
                }
            }
        }
        return flag;
    }
}
