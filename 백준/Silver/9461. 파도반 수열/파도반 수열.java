import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());
            if(N<=3){
                bw.write("1\n");
            }else{
                long[] arr = new long[N+1];
                arr[1] = 1;
                arr[2] = 1;
                arr[3] = 1;
                for(int i=4;i<=N;i++){
                    arr[i] = arr[i-2]+arr[i-3];
                }
                bw.write(arr[N]+"\n");
            }
        }
        bw.close();
    }
    
}