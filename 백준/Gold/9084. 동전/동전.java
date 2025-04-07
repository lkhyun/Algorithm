import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for(int t = 1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            coins = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());

            dp = new int[M+1];
            dp[0] = 1;

            for(int i=0;i<N;i++){
                for(int j=0;j<=M;j++){
                    if(j-coins[i]>=0){
                        dp[j] += dp[j-coins[i]];
                    }
                }
            }

        
            bw.write(dp[M]+"\n");
        }
        
        bw.close(); 
    }
}
