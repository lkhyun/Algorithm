import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] apt = new int[k+1][n+1];  //k층, n호
            for(int i=1;i<=n;i++){ //0층의 i호는 i명이 산다.
                apt[0][i] = i;
            }
            for(int i=1;i<=k;i++){ //모든층의 1호는 1명이 산다.
                apt[i][1] = 1;
            }
            for(int i=1;i<=k;i++){
                for(int j=1;j<=n;j++){
                    apt[i][j] = apt[i][j-1] + apt[i-1][j]; // k층의 n호에는 k층의 n-1호와 k-1층의 n호에 사는 수의 합과 같다.
                }
            }
            bw.write(apt[k][n]+"\n");
        }    
        bw.flush();
    }
    
}
