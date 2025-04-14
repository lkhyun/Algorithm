import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static char[][] matrix;
    static int starti;
    static int startj;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = str[j];
                if (matrix[i][j] == 'I') {
                    starti = i;
                    startj = j;
                }
            }
        }
        int answer = BFS();
        if (answer == 0) {
            bw.write("TT");
        } else {
            bw.write(answer + "");
        }

        bw.close();
    }

    public static int BFS() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        int cnt = 0;

        q.add(new int[] {starti, startj});
        visited[starti][startj] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (matrix[cur[0]][cur[1]] == 'P') {
                cnt++;
            }

            for (int k = 0; k < 4; k++) {
                int[] next = new int[2];
                next[0] = cur[0] + di[k];
                next[1] = cur[1] + dj[k];

                if (next[0] < 0 || next[0] >= N || next[1] < 0 || next[1] >= M
                        || visited[next[0]][next[1]])
                    continue;

                if (matrix[next[0]][next[1]] != 'X') {
                    q.add(next);
                    visited[next[0]][next[1]] = true;
                }
            }
        }
        return cnt;
    }
}
