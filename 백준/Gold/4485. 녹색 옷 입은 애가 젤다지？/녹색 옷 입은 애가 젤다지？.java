import java.io.*;
import java.util.*;

class Node{
    int i,j,weight;

    public Node(int i, int j, int weight) {
        this.i = i;
        this.j = j;
        this.weight = weight;
    }
    
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T = 1;
    static int N;
    static int[][] matrix;
    static int min;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,1,-1};
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            matrix = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()); 
                for(int j=0;j<N;j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            dijkstra();
            bw.write("Problem "+T+": "+min+"\n");
            T++;
            st = new StringTokenizer(br.readLine());
        }
        bw.close();
    }
    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight-b.weight);
        pq.add(new Node(0,0,matrix[0][0]));
        int[][] dist =  new int[N][N];
        for(int i=0;i<N;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        dist[0][0] = matrix[0][0];

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.i][cur.j] < cur.weight) continue;
            
            for(int k = 0;k<4;k++){
                int newi = cur.i + di[k];
                int newj = cur.j + dj[k];
                if(newi<0 || newi>=N || newj<0 || newj>=N) continue;
                int newdistance = dist[cur.i][cur.j] + matrix[newi][newj];
                if(dist[newi][newj]>newdistance){
                    dist[newi][newj] = newdistance;
                    pq.add(new Node(newi,newj,newdistance));
                }
            }
        }
        min = dist[N-1][N-1];
    }
}
