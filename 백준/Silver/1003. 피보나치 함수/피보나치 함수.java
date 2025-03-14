import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());
            int[] zeroCnt = new int[N+1];
            int[] oneCnt = new int[N+1];
            if(N==0){
                bw.write("1 0\n");
                continue;
            }
            zeroCnt[0] = 1;
            zeroCnt[1] = 0;
            oneCnt[0] = 0;
            oneCnt[1] = 1;
            for(int i=2;i<=N;i++){
                zeroCnt[i] = zeroCnt[i-1] + zeroCnt[i-2];
                oneCnt[i] = oneCnt[i-1] + oneCnt[i-2];
            }
            bw.write(zeroCnt[N] + " " + oneCnt[N] + "\n");
        }
        bw.close();
    }
}
