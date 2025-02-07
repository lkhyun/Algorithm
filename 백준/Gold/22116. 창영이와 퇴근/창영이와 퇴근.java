import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int i, j, maxSlope;

    Node(int i, int j, int maxSlope) {
        this.i = i;
        this.j = j;
        this.maxSlope = maxSlope;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.maxSlope, other.maxSlope); // 최소 경사값을 기준으로 정렬
    }
}

public class Main {
    static int N;
    static int[][] grid;
    static int[][] dist;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = Integer.MAX_VALUE; // 최대 경사를 저장하므로, 최댓값으로 초기화
            }
        }

        dijkstra();

        bw.write(dist[N - 1][N - 1] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));  // 시작 위치, 초기 경사 0
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.maxSlope > dist[current.i][current.j]) continue; // 기존 값보다 크면 무시

            for (int d = 0; d < 4; d++) {
                int newi = current.i + di[d];
                int newj = current.j + dj[d];

                if (newi >= 0 && newi < N && newj >= 0 && newj < N) {
                    int slope = Math.abs(grid[newi][newj] - grid[current.i][current.j]); // 경사 계산
                    int newMaxSlope = Math.max(current.maxSlope, slope); // 경로 중 최대 경사 갱신

                    if (dist[newi][newj] > newMaxSlope) { // 더 작은 최대 경사값을 찾으면 갱신
                        dist[newi][newj] = newMaxSlope;
                        pq.add(new Node(newi, newj, newMaxSlope));
                    }
                }
            }
        }
    }
}
