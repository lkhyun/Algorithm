import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];
            dp[0] = 1;
            for (int i = 1; i <= 3; i++) {
                for (int j = i; j <= n; j++) {
                    dp[j] += dp[j-i];
                }
            }
            bw.write(dp[n] + "\n");
        }
        bw.close();
    }
}