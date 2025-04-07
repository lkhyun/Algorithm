import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[] bytes;
    static int[] costs;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        bytes = new int[N];
        costs = new int[N];

        int memorySize = M;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            bytes[i] = Integer.parseInt(st.nextToken());
            memorySize += bytes[i];
        }
        dp = new int[memorySize+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0;i<N;i++){
            for(int j=memorySize;j>=bytes[i];j--){
                if(dp[j-bytes[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-bytes[i]]+costs[i]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=M;i<=memorySize;i++){
            min = Math.min(min,dp[i]);
        }
        bw.write(min+"");
        bw.close(); 
    }
}
