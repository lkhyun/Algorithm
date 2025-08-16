import java.io.*;
import java.util.*;

public class Main {
    static int N,T;
    static int[][] farm;
    static long[][][] dist;
    static int[] di = {0,0,-1,1};
    static int[] dj = {-1,1,0,0};
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        farm = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dijkstra();
        bw.write(ans+"");
        bw.close();
    }

    static void dijkstra(){
        dist = new long[N][N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j],Long.MAX_VALUE);
            }
        }
        dist[0][0][0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[2],b[2]));
        pq.offer(new long[]{0,0,0,0}); // a,b,c,d : [a][b]까지 가는데 c만큼 걸리고 길 건넌 횟수는 d이다.

        while(!pq.isEmpty()){
            long[] cur = pq.poll();

            if(dist[(int)cur[0]][(int)cur[1]][(int)cur[3]] < cur[2]) continue;
    
            for (int k = 0; k < 4; k++) {
                int newi = (int)(cur[0] + di[k]);
                int newj = (int)(cur[1] + dj[k]);
                if(check(newi,newj)){
                    long newDist = cur[2] + T;
                    int newCross = (int)(cur[3]+1) % 3;
                    if(newCross == 0){
                        newDist += farm[newi][newj];
                    }
                    if(newDist < dist[newi][newj][newCross]){
                        dist[newi][newj][newCross] = newDist;
                        pq.offer(new long[]{newi,newj,newDist,newCross});
                    }
                }
            }
        }
        ans = Math.min(dist[N-1][N-1][0],Math.min(dist[N-1][N-1][1], dist[N-1][N-1][2]));
    }
    static boolean check(long a, long b){
        if(a<0 || a>=N || b<0 || b>=N) return false;
        return true;
    }
}