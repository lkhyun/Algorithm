import java.io.*;
import java.util.Arrays;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        Arrays.fill(dp,4);
        for(int i=1;i*i<=N;i++){
            dp[i*i] = 1;
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j*j<i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }

        bw.write(dp[N]+"");
        bw.close();
    }
}
