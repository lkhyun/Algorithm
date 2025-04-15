import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int vertex;
        Node next;

        public Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static Node[] adjList;
    static int min = Integer.MAX_VALUE;
    static int minvertex;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new Node[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
        }
        for (int i = 1; i <= N; i++) {
            int temp = BFS(i);
            if (min > temp) {
                minvertex = i;
                min = temp;
            } else if (min == temp) {
                minvertex = Math.min(minvertex, i);
            }
        }


        bw.write(minvertex + "");

        bw.close();
    }

    public static int BFS(int start) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        q.add(new int[] {start, 0});
        visited[start] = true;
        int kebin = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            kebin += cur[1];

            for (Node n = adjList[cur[0]]; n != null; n = n.next) {
                if (visited[n.vertex])
                    continue;
                q.add(new int[] {n.vertex, cur[1] + 1});
                visited[n.vertex] = true;
            }
        }
        return kebin;
    }
}
