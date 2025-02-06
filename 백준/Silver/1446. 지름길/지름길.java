import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int vertex, weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n) {
        return this.weight - n.weight;
    }
}

public class Main {
    final static int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] dist;

    public static void dijkstra(int start, int D) {
        PriorityQueue<Node> minheap = new PriorityQueue<>();
        Arrays.fill(dist, INF); // 거리 초기화
        dist[start] = 0;
        minheap.add(new Node(start, 0));

        while (!minheap.isEmpty()) {
            Node current = minheap.poll();
            
            if (current.weight > dist[current.vertex]) continue;
            
            for (Node next : graph[current.vertex]) {
                int newWeight = dist[current.vertex] + next.weight;
                if (dist[next.vertex] > newWeight) {
                    dist[next.vertex] = newWeight;
                    minheap.add(new Node(next.vertex, newWeight));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[D + 1];
        dist = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (end <= D && (end - start) > weight) { // 일방통행이니까 목적지보다 더 가거나 굳이 탈 이유가 없는 지름길 제외
                graph[start].add(new Node(end, weight));
            }
        }
        for (int i = 0; i < D; i++) { //지름길 안타는 경우우
            graph[i].add(new Node(i + 1, 1));
        }

        // 다익스트라 실행
        dijkstra(0, D);

        // 최단 거리 출력
        bw.write(dist[D] + "\n");
        bw.flush();
        bw.close();
    }
}
