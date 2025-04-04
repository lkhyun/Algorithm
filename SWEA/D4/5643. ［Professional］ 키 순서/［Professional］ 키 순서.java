import java.io.*;
import java.util.*;

public class Solution {
    static int N; 
    static int M;
    static boolean[][] matrix;
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            bw.write("#"+t+" ");
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            matrix = new boolean[N+1][N+1];
            for(int i=0;i<N;i++) Arrays.fill(matrix[i],false);

            for(int i=1;i<=M;i++){
                st = new StringTokenizer(br.readLine());
                int small = Integer.parseInt(st.nextToken());
                int big = Integer.parseInt(st.nextToken());
                matrix[small][big] = true;
            }

            for(int k=1;k<=N;k++){
                for(int i=1;i<=N;i++){
                    for(int j=1;j<=N;j++){
                        matrix[i][j] = matrix[i][j] || (matrix[i][k] && matrix[k][j]);
                    }
                }
            }

            int total = 0;
            for(int i=1;i<=N;i++){
                boolean flag = true;
                for(int j=1;j<=N;j++){
                    if(i==j) continue;
                    if(!matrix[i][j] && !matrix[j][i]){
                        flag = false;
                    }
                }
                if(flag) total++;
            }
            bw.write(total+"\n");
        }
        bw.close();
    }

}
