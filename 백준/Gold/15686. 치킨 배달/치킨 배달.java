import java.util.*;
import java.io.*;

class Node{
    int i,j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[][] graph;
    static List<Node> houses = new ArrayList<>();
    static List<Node> chickens = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int input = Integer.parseInt(st.nextToken());
                if(input == 1){
                    houses.add(new Node(i,j));
                }else if(input == 2){
                    chickens.add(new Node(i, j));
                }
                graph[i][j] = 0;
            }
        }

        backtracking(0,0);
        bw.write(min+"");
        bw.close();
    }
    public static void backtracking(int depth,int start){
        if(depth == M){
            int sum = 0;
            for(Node n : houses){
                int temp = BFS(n);
                if(temp == -1) continue;
                sum += temp;
                if(sum > min) return;
            }
            min = sum;
            return;
        }

        for(int i=start; i<chickens.size();i++){
            Node n = chickens.get(i);
            graph[n.i][n.j] = 2;
            backtracking(depth+1, i+1);
            graph[n.i][n.j] = 0;
        }
    }
    public static int BFS(Node start){
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+1][N+1];
        int[] di = {0,0,-1,1};
        int[] dj = {-1,1,0,0};
        q.add(start);
        visited[start.i][start.j] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(graph[cur.i][cur.j] == 2){
                int dist = Math.abs(start.i-cur.i) + Math.abs(start.j-cur.j);
                return dist;
            }
            
            for(int k=0;k<4;k++){
                int newi = cur.i + di[k];
                int newj = cur.j + dj[k];
                if(newi<1 || newi>N || newj<1 || newj>N || visited[newi][newj]) continue;
                q.add(new Node(newi, newj));
                visited[newi][newj] = true;
            }
        }
        return -1;
    }
}