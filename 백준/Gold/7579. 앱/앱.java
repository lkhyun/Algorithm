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

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            bytes[i] = Integer.parseInt(st.nextToken());
        }

        int memorySize = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            costs[i] = Integer.parseInt(st.nextToken());
            memorySize += costs[i];
        }
        dp = new int[memorySize+1];

        for(int i=0;i<N;i++){
            for(int j=memorySize;j>=costs[i];j--){
                dp[j] = Math.max(dp[j],dp[j-costs[i]]+bytes[i]);
            }
        }
        int idx = 0;
        for(int i=0;i<=memorySize;i++){
            if(dp[i]>=M){
                idx = i;
                break;
            }
        }
        bw.write(idx+"");
        bw.close(); 
    }
}
