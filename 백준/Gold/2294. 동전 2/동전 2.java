import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,K;
    static Set<Integer> coins;
    static int[] dp; //dp[i]: i원을 만드는데 필요한 동전의 최소 개수
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new HashSet<>();
        dp = new int[K+1];
        for (int i = 0; i < N; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i : coins) {
            for (int j = i; j <= K; j++) {
                if(dp[j-i] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-i]+1);
                }
            }
        }
        int ans = dp[K] == Integer.MAX_VALUE ? -1 : dp[K];

        bw.write(ans + "");
        bw.close();
    }
}