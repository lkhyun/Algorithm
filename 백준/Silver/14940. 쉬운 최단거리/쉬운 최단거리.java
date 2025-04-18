import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        int starti = 0, startj = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    starti = i;
                    startj = j;
                }
            }
        }
        BFS(starti, startj);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bw.write("-1 ");
                } else {
                    bw.write(dist[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }

    public static void BFS(int starti, int startj) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] di = {0, 0, -1, 1};
        int[] dj = {-1, 1, 0, 0};
        q.offer(new int[] {starti, startj, 0});
        visited[starti][startj] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            dist[cur[0]][cur[1]] = cur[2];

            for (int i = 0; i < 4; i++) {
                int newi = cur[0] + di[i];
                int newj = cur[1] + dj[i];
                if (newi < 0 || newi >= n || newj < 0 || newj >= m || visited[newi][newj]
                        || map[newi][newj] == 0)
                    continue;
                q.add(new int[] {newi, newj, cur[2] + 1});
                visited[newi][newj] = true;
            }
        }
    }
}


