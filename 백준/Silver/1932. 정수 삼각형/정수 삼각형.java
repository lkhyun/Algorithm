import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] triangle;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            dp[N-1][i] = triangle[N-1][i];
        }
        for (int i = N-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int temp = Math.max(dp[i][j], dp[i][j+1]);
                dp[i-1][j] = triangle[i-1][j] + temp;
            }
        }
        bw.write(dp[0][0]+"");
        bw.close();
    }
}
