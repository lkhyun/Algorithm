import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] grid;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, grid[i][j]);
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
        }

        // 이분 탐색: 가능한 최대 경사의 최솟값을 찾음
        int left = 0, right = maxHeight - minHeight;
        int result = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {  // mid 이하의 경사만으로 목적지 도달 가능?
                result = mid;  // 정답 업데이트
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    // BFS를 이용하여 최대 경사 mid 이하로 목적지까지 도달 가능한지 확인
    public static boolean isPossible(int maxSlope) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];

            if (i == N - 1 && j == N - 1) return true;  // 목적지 도착 가능

            for (int d = 0; d < 4; d++) {
                int newi = i + di[d];
                int newj = j + dj[d];

                if (newi >= 0 && newi < N && newj >= 0 && newj < N && !visited[newi][newj]) {
                    int slope = Math.abs(grid[newi][newj] - grid[i][j]);

                    if (slope <= maxSlope) {  // mid 이하의 경사만 이동 가능
                        visited[newi][newj] = true;
                        queue.add(new int[]{newi, newj});
                    }
                }
            }
        }
        return false;  // 목적지까지 도달 불가능
    }
}
