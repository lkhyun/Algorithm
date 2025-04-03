import java.io.*;
import java.util.*;
class Node{
    int i,j;
    Node(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M;
    static int N;
    static int K;
    static int[][] matrix;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int cnt = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1;t<=T;t++){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            matrix = new int[M][N];
            visited = new boolean[M][N];
            cnt = 0;
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                matrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(matrix[i][j] == 1 && !visited[i][j]){
                        BFS(i,j);
                    }
                }
            }
            bw.write(cnt+"\n");
        }
       
        bw.close();
    }
    public static void BFS(int starti,int startj){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(starti,startj));
        visited[starti][startj] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int k = 0;k<4;k++){
                int newi = cur.i + di[k];
                int newj = cur.j + dj[k];
                if(newi<0 || newi>=M || newj<0 || newj>=N || visited[newi][newj] || matrix[newi][newj] == 0) continue;
                q.add(new Node(newi,newj));
                visited[newi][newj] = true;
            }
        }
        cnt++;
    }
}
