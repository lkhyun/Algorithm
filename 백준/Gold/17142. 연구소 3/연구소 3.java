import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int i, j,time;

        public Node(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] matrix;
    static List<Node> virus = new ArrayList<>();
    static List<Node> selected = new ArrayList<>();
    static int[] di = {0, 0, -1, 1};
    static int[] dj = {-1, 1, 0, 0};
    static int min = Integer.MAX_VALUE;
    static int zeroCnt = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 2) {
                    virus.add(new Node(i, j,0));
                }else if(matrix[i][j] == 0){
                    zeroCnt++;
                }
            }
        }
        combination(0, 0);
        if(min == Integer.MAX_VALUE) bw.write("-1");
        else bw.write(min + "");
        bw.close();
    }

    public static void combination(int start, int count) {
        if (count == M) {
            BFS();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            selected.add(virus.get(i));
            combination(i + 1, count + 1);
            selected.remove(selected.size() - 1);
        }
    }

    public static void BFS() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        for (Node temp : selected) {
            pq.add(temp);
            dist[temp.i][temp.j] = 0;
        }
        int maxTime = 0;
        int remainZero = zeroCnt;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (matrix[cur.i][cur.j] == 0) remainZero--;
            if (remainZero == 0) {
                maxTime = Math.max(maxTime, cur.time);
                min = Math.min(min,maxTime);
                return;
            }
            if(dist[cur.i][cur.j] < cur.time) continue;
            for (int k = 0; k < 4; k++) {
                int newi = cur.i + di[k];
                int newj = cur.j + dj[k];

                if (newi < 0 || newi >= N || newj < 0 || newj >= N || matrix[newi][newj] == 1)
                    continue;

                if (dist[newi][newj] > cur.time + 1) {
                    pq.add(new Node(newi, newj, cur.time + 1));
                    dist[newi][newj] = cur.time + 1;
                }
            }

        }
    }
}

