import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1]; //dp[N] = N킬로그램을 만드는 봉지의 개수
        dp[3] = 1;
        if(N>=5){
            dp[5] = 1;
        }
        for(int i=6;i<=N;i++){
            if(dp[i-3] != 0 && dp[i-5] != 0){
                dp[i] = Math.min(dp[i-3]+1,dp[i-5]+1);
            }else if(dp[i-3] != 0){
                dp[i] = dp[i-3]+1;
            }else if(dp[i-5] != 0){
                dp[i] = dp[i-5]+1;
            }
        }
        if(dp[N]==0){
            bw.write("-1");
        }else{
            bw.write(dp[N]+"");
        }
        bw.flush();
    }    
}