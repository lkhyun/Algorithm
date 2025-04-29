import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static List<Integer>[] adjList;
    static int[] parent;


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N+1];
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A].add(B);
            adjList[B].add(A);
        }
        BFS();
        for (int i = 2; i <= N; i++) {
            bw.write(parent[i] + "\n");
        }
        bw.flush();
    }
    public static void BFS() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        parent[1] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer next : adjList[cur]) {
                if (parent[next] == 0) {
                    parent[next] = cur;
                    q.add(next);
                }
            }
        }
    }
}
