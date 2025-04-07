import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int K;
    static int[] weights;
    static int[] values;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        weights = new int[N];
        values = new int[N];
        dp = new int[K+1];
        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            for(int j=K;j>=weights[i];j--){
                dp[j] = Math.max(dp[j],dp[j-weights[i]]+values[i]);
            }
        }
        bw.write(dp[K]+"");
        bw.close(); 
    }
}
