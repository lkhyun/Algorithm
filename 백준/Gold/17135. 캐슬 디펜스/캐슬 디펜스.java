import java.util.*;
import java.io.*;

class Point {
    int x, y;
    Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, D, max = 0;
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        grid = new int[N+1][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(max);
    }

    public static void combination(int start, int cnt) {
        if (cnt == 3) { // 궁수 3명 배치 완료
            int[][] arr = new int[N+1][M];
            for (int i = 0; i < N+1; i++) {
                arr[i] = Arrays.copyOf(grid[i], M);
            }
            max = Math.max(max, playSimulation(arr));
            return;
        }

        for (int i = start; i < M; i++) {
            grid[N][i] = 1;
            combination(i + 1, cnt + 1);
            grid[N][i] = 0;
        }
    }

    public static int playSimulation(int[][] arr) {
        int count = 0;
        int[] dx = {-1, 0, 1};
        int[] dy = {0, -1, 0};

        while (true) {
            boolean[][] erase = new boolean[N+1][M];

            // 궁수 공격 처리
            for (int i = 0; i < M; i++) {
                if (arr[N][i] == 1) {
                    Queue<Point> q = new ArrayDeque<>();
                    boolean[][] visited = new boolean[N+1][M];
                    q.add(new Point(N-1, i));
                    visited[N-1][i] = true;

                    while (!q.isEmpty()) {
                        Point cur = q.poll();

                        if (Math.abs(N - cur.y) + Math.abs(i - cur.x) > D) break;
                        if (arr[cur.y][cur.x] == 1) {
                            erase[cur.y][cur.x] = true;
                            break;
                        }

                        for (int j = 0; j < 3; j++) {
                            int newX = cur.x + dx[j];
                            int newY = cur.y + dy[j];

                            if (newX >= 0 && newX < M && newY >= 0 && !visited[newY][newX]) {
                                visited[newY][newX] = true;  // 방문 처리
                                q.add(new Point(newY, newX));
                            }
                        }
                    }
                }
            }

            // 적 제거
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (erase[i][j]) {
                        arr[i][j] = 0;
                        count++;
                    }
                }
            }

            // 적 이동
            if (retry(arr)) {
                for (int i = N - 2; i >= 0; i--) {
                    for (int j = 0; j < M; j++) {
                        arr[i + 1][j] = arr[i][j];
                    }
                }
                Arrays.fill(arr[0], 0); // 맨 윗줄 초기화
            } else {
                return count;
            }
        }
    }

    public static boolean retry(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) return true;
            }
        }
        return false;
    }
}
