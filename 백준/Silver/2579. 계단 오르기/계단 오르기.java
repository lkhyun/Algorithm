import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] stairs = new int[N+1];
        int[] dp = new int[N+1];
        stairs[0] = 0;
        for(int i=1; i<=N; i++){
            stairs[i] = sc.nextInt();
        }
        if(N == 1){System.out.println(stairs[1]); return;}
        dp[0] = 0;
        dp[1] = stairs[1];
        dp[2] = dp[1]+stairs[2];
        for(int i=3;i<=N;i++){
            dp[i] = stairs[i];
            dp[i] += Math.max(dp[i-3]+stairs[i-1],dp[i-2]);
        }
       System.out.println(dp[N]);
    }
}
