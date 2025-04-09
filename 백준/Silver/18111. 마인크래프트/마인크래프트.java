import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M,B;
    static int[][] matrix;
    static int min = Integer.MAX_VALUE;
    static int maxlocal;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int k=0;k<=256;k++){
            int time = 0;
            int remainblocks = B;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(matrix[i][j]<=k){
                        time += k - matrix[i][j];
                        remainblocks-= k - matrix[i][j];
                    }else{
                        time += (matrix[i][j] - k)*2;
                        remainblocks += matrix[i][j] - k;
                    }
                }
            }
            if(remainblocks<0) break;
            if(min>=time){
                min = time;
                maxlocal = k;
            }
        }
        bw.write(min+" "+maxlocal+"\n");

        bw.close(); 
    }
}
