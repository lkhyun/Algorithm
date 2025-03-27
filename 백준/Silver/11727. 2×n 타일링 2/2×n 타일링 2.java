import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=N;i++){
            dp[i] = (dp[i-2]*2 + dp[i-1])%10007;
        }
        bw.write(dp[N]+"");
        bw.close();
    }
    
}