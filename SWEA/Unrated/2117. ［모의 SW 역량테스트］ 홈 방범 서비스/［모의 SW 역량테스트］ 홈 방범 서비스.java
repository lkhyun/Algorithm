import java.io.*;
import java.util.*;

class Node{
    int i,j,depth;

    public Node(int i, int j, int depth) {
        this.i = i;
        this.j = j;
        this.depth = depth;
    }
    
}
public class Solution {
    static int N;
    static int M;
    static int[][] matrix;
    static int max;
    static int[] di = {0,0,-1,1};
    static int[] dj = {-1,1,0,0};
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            bw.write("#"+t+" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            matrix = new int[N][N];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int k=1;k<=N+1;k++){
                        BFS(i,j,k);
                    }   
                }
            }
            bw.write(max+"\n");
        }
        bw.close();
    }
    public static void BFS(int starti,int startj, int range){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(starti, startj, 1));
        boolean[][] visited = new boolean[N][N];
        visited[starti][startj] = true;
        int count = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(matrix[cur.i][cur.j] == 1) count++;
            if(cur.depth == range) continue;

            for(int k=0;k<4;k++){
                int newi = cur.i + di[k];
                int newj = cur.j + dj[k];
                if(newi<0 || newi>=N || newj<0 || newj>=N || visited[newi][newj]) continue;
                q.add(new Node(newi,newj,cur.depth+1));
                visited[newi][newj] = true;
            }
        }
        int service = (range*range) + ((range-1)*(range-1)); 
        if(count*M >= service){
            max = Math.max(max,count);
        }
    }
}
