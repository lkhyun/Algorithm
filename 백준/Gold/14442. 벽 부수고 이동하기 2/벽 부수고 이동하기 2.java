import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M,K;
    static char[][] matrix;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        matrix = new char[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = line.charAt(j-1);
            }
        }

        int result = BFS();
        bw.write(result + "");
        bw.close();
    }

    static int BFS() {
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] maxK = new int[N+1][M+1]; // 각 위치에서 도달했을 때 최대 남은 벽 개수

        for(int i = 0; i <= N; i++) {
            Arrays.fill(maxK[i], -1);
        }

        q.offer(new int[]{1,1,K,1});
        maxK[1][1] = K;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == N && cur[1] == M){
                return cur[3];
            }

            if(maxK[cur[0]][cur[1]] > cur[2]) continue;

            for (int k = 0; k < 4; k++) {
                int ni = cur[0] + di[k];
                int nj = cur[1] + dj[k];

                if(ni<=0 || ni>N || nj<=0 || nj>M){
                    continue;
                }

                if(matrix[ni][nj]=='0'){
                    if(maxK[ni][nj] < cur[2]){
                        maxK[ni][nj] = cur[2];
                        q.offer(new int[]{ni,nj,cur[2],cur[3]+1});
                    }
                }else if(matrix[ni][nj]=='1' && cur[2]>0){
                    if(maxK[ni][nj] < cur[2]-1){
                        maxK[ni][nj] = cur[2]-1;
                        q.offer(new int[]{ni,nj,cur[2]-1,cur[3]+1});
                    }
                }
            }
        }
        return -1;
    }
}