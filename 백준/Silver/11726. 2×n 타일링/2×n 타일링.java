import java.util.*;
import java.io.*;

public class Main {
    static int N;
    final static int MOD = 10007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=N;i++){
            dp[i] = (dp[i-2] + dp[i-1])%MOD;
        }
        bw.write(dp[N]+"");
        bw.close();
    }
}