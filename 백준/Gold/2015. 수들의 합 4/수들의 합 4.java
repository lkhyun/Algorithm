import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,K;
    static long[] A;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = A[i-1] + Integer.parseInt(st.nextToken());
        }

        Map<Long, Integer> SumCount = new HashMap<>();
        long count = 0;
        
        SumCount.put(0L, 1);
        
        for (int j = 1; j <= N; j++) {
            long target = A[j] - K;
            count += SumCount.getOrDefault(target, 0);
            
            SumCount.put(A[j], SumCount.getOrDefault(A[j], 0) + 1);
        }
        bw.write(count + "\n");
        bw.close();
    }
}