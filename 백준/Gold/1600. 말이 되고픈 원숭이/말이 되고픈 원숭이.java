import java.io.*;
import java.util.*;

class Node{
    int i,j,skillcnt,movecnt;

    public Node(int i, int j, int skillcnt, int movecnt) {
        this.i = i;
        this.j = j;
        this.skillcnt = skillcnt;
        this.movecnt = movecnt;
    }
    
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int K;
    static int H;
    static int W;
    static int[][] matrix;
    static int min;
    static int[] jumpi = {-1,1,0,0};
    static int[] jumpj = {0,0,1,-1};
    static int[] superjumpi = {-2,-2,-1,-1,1,1,2,2};
    static int[] superjumpj = {-1,1,-2,2,-2,2,-1,1};

    public static void main(String[] args) throws Exception{
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        matrix = new int[H][W];

        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0;j<W;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        BFS();
        if(min == Integer.MAX_VALUE) min = -1;
        bw.write(min+"");
        bw.close();
    }
    public static void BFS(){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.movecnt - b.movecnt);
        pq.add(new Node(0, 0,K,0));
        int[][][] dist = new int[H][W][K+1];
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        dist[0][0][K] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.i][cur.j][cur.skillcnt] < cur.movecnt) continue;

            if(cur.skillcnt > 0){
                for(int k=0;k<8;k++){
                    int newi = cur.i + superjumpi[k];
                    int newj = cur.j + superjumpj[k];
                    if(newi<0 || newi>=H || newj<0 || newj>=W || matrix[newi][newj] == 1) continue;
                    int newdistance = dist[cur.i][cur.j][cur.skillcnt] + 1;
                    if(dist[newi][newj][cur.skillcnt-1]>newdistance){
                        dist[newi][newj][cur.skillcnt-1] = newdistance;
                        pq.add(new Node(newi,newj,cur.skillcnt-1,newdistance));
                    }
                }
            }
            for(int k=0;k<4;k++){
                int newi = cur.i + jumpi[k];
                int newj = cur.j + jumpj[k];
                if(newi<0 || newi>=H || newj<0 || newj>=W || matrix[newi][newj] == 1) continue;
                int newdistance = dist[cur.i][cur.j][cur.skillcnt] + 1;
                if(dist[newi][newj][cur.skillcnt]>newdistance){
                    dist[newi][newj][cur.skillcnt] = newdistance;
                    pq.add(new Node(newi,newj,cur.skillcnt,newdistance));
                }
            }
        }
        for(int i=0;i<=K;i++){
            min = Math.min(min,dist[H-1][W-1][i]);
        }
        
    }
}
