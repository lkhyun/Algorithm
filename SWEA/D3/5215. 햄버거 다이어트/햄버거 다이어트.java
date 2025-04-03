import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int L;
    static int[] flavor;
    static int[] cal;
    static int[] dp;
    static int max;
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            bw.write("#"+t+" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            flavor = new int[N+1];
            cal = new int[N+1];
            dp = new int[L+1]; //칼로리당 맛 저장
            max = 0;

            for(int i=1;i<=N;i++){
                st = new StringTokenizer(br.readLine());
                flavor[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=N;i++){
                for(int j=L;j>=cal[i];j--){
                    dp[j] = Math.max(dp[j],dp[j-cal[i]]+flavor[i]);
                }
            }
            for(int i : dp){
                max = Math.max(max,i);
            }
            bw.write(max+"\n");
        }
        
        bw.close();
    }
}
