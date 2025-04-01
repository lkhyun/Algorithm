import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] graph;
    static int[][][] dp;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dp = new int[N][N][1 << N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        for (int i = 0; i < N; i++) {
            int result = tsp(i, i, 1 << i);
            min = Math.min(min, result);
        }

        bw.write(min == Integer.MAX_VALUE ? "0" : min + "\n");
        bw.close();
    }

    public static int tsp(int start, int current, int visited) {
        if (visited == (1 << N) - 1) {
            return graph[current][start] == 0 ? Integer.MAX_VALUE : graph[current][start];
        }

        if (dp[start][current][visited] != -1) return dp[start][current][visited];

        dp[start][current][visited] = Integer.MAX_VALUE;

        for (int next = 0; next < N; next++) {
            // 이미 방문했거나 경로가 없다면 스킵
            if ((visited & (1 << next)) != 0 || graph[current][next] == 0) continue;

            int nextVisited = visited | (1 << next);
            int cost = tsp(start, next, nextVisited);
            if (cost != Integer.MAX_VALUE) {
                dp[start][current][visited] = Math.min(
                    dp[start][current][visited],
                    cost + graph[current][next]
                );
            }
        }

        return dp[start][current][visited];
    }
}
