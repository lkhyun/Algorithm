import java.util.*;
import java.io.*;

public class Solution{
    static int[] fee = new int[4];
    static int[] monthPlan = new int[13];
    static int[] dp = new int[13];
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<4;i++){
                fee[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=12;i++){
                monthPlan[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp,0);
            for(int i=1;i<=12;i++){
                dp[i] = Math.min(dp[i-1]+monthPlan[i]*fee[0],dp[i-1]+fee[1]);
                if(i>=3){
                    dp[i] = Math.min(dp[i],dp[i-3]+fee[2]);
                }else{
                    dp[i] = Math.min(dp[i],fee[2]);
                }
            }
            int min = Math.min(dp[12],fee[3]);
            bw.write("#"+t+" "+min+"\n");
        }
        bw.close();
    }
}