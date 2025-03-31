import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int to, weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Solution {
    static int V, E;
    static List<Node>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            bw.write("#" + t + " ");
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adjList = new ArrayList[V + 1];
            visited = new boolean[V + 1];

            for (int i = 0; i <= V; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                adjList[from].add(new Node(to, weight));
                adjList[to].add(new Node(from, weight));
            }
            int start = 0;
            for(int i=0;i<=V;i++){
                if(adjList[i].size()!=0){
                    start = i;
                    break;
                }
            }
            long total = prim(start);
            bw.write(total + "\n");
        }
        bw.close();
    }

    public static long prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        long total = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.to]) continue;
            visited[current.to] = true;
            total += current.weight;

            if (++count == V) break;

            for (Node next : adjList[current.to]) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }
        return total;
    }
}
