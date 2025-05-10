import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[2][N];
        for (int i = 0; i < N; i++) {
            dp[0][i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    dp[0][i] = Math.max(dp[0][j]+1, dp[0][i]);
                }
            }
        }
        for (int i = N-1; i >= 0; i--) {
            dp[1][i] = 1;
            for (int j = N-1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dp[1][i] = Math.max(dp[1][j] + 1, dp[1][i]);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[0][i] + dp[1][i]);
        }
        bw.write(max-1 + "");
        bw.close();
    }
}
