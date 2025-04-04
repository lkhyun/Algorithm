import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, V;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        // 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        // DFS
        boolean[] visited = new boolean[N + 1];
        DFS(V, visited);
        bw.write("\n");

        // BFS
        visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(V);
        visited[V] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            bw.write(cur + " ");
            for (int next : adjList[cur]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        bw.close();
    }

    public static void DFS(int start, boolean[] visited) throws Exception {
        visited[start] = true;
        bw.write(start + " ");
        for (int next : adjList[start]) {
            if (!visited[next]) {
                DFS(next, visited);
            }
        }
    }
}
