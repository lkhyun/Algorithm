import java.io.*;
import java.util.*;

public class Main {

    static int M, N, H;
    static int[][][] box;
    static int[] di = {-1, 1, 0, 0, 0, 0};
    static int[] dj = {0, 0, -1, 1, 0, 0};
    static int[] dk = {0, 0, 0, 0, -1, 1};
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static boolean[][][] visited;
    static int day = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        q.add(new int[] {i, j, k, 0});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            box[cur[0]][cur[1]][cur[2]] = 1;
            day = Math.max(day, cur[3]);
            for (int k = 0; k < 6; k++) {
                int newi = cur[0] + di[k];
                int newj = cur[1] + dj[k];
                int newk = cur[2] + dk[k];

                if (newi < 0 || newj < 0 || newk < 0 || newi >= H || newj >= N || newk >= M
                        || visited[newi][newj][newk])
                    continue;
                if (box[newi][newj][newk] == 0) {
                    q.add(new int[] {newi, newj, newk, cur[3] + 1});
                    visited[newi][newj][newk] = true;
                }
            }
        }
        boolean flag = false;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (flag || box[i][j][k] == 0) {
                        flag = true;
                        break;
                    }
                }
            }
        }

        if (flag) {
            bw.write("-1");
        } else {
            bw.write(day + "");
        }
        bw.close();
    }
}
