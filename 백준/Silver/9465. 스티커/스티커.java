import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[1][j] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[2][N];

            for (int j = 0; j < N; j++) {
                if(j==0){
                    dp[0][0] = arr[0][0];
                    dp[1][0] = arr[1][0];
                    max = Math.max(dp[0][0],dp[1][0]);
                    continue;
                }
                if(j==1){
                    dp[0][1] = arr[0][1] + arr[1][0];
                    dp[1][1] = arr[1][1] + arr[0][0];
                    int temp = Math.max(dp[0][1],dp[1][1]);
                    max = Math.max(temp,max);
                    continue;
                }
                int temp = Math.max(dp[0][j-2],dp[1][j-2]);
                dp[0][j] = arr[0][j] + Math.max(temp,dp[1][j-1]);
                dp[1][j] = arr[1][j] + Math.max(temp,dp[0][j-1]);
                temp = Math.max(dp[0][j],dp[1][j]);
                max = Math.max(temp,max);
            }
            bw.write(max+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
