import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T,N;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[2] == b[2]){
                return Integer.compare(a[0],b[0]);
            }else{
                return Integer.compare(b[2],a[2]);
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int remain = Integer.parseInt(st.nextToken());
            int prior = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{id,remain,prior});
        }

        for (int i = 1; i <= T; i++) {
            int[] cur = pq.poll();
            bw.write(cur[0]+"\n");
            if(--cur[1] > 0){
                cur[2]--;
                pq.offer(cur);
            }
        }
        
        bw.close();
    }
}