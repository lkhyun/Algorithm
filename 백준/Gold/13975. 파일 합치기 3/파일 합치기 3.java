import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            PriorityQueue<Long> pq = new PriorityQueue<>();

            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {  
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long ans = 0;
            while(pq.size() != 1){
                long cur1 = pq.poll();
                long cur2 = pq.poll();
                ans += cur1+cur2;
                pq.offer(cur1+cur2);
            }
            bw.write(ans+"\n");
        }
        bw.close();
    }
}