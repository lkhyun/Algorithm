import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            cnt = 0;
            find(0);
            bw.write(cnt+"\n");
        }
        bw.close();
    }
    public static void find(int sum){
        if(sum == N){
            cnt++;
        }
        if(sum>N) return;

        for(int i=1;i<=3;i++){
            find(sum+i);
        }
    }
    
}
