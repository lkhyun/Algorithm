import java.util.*;
import java.io.*;

public class Solution {
    static int[] di = {-1,0,0,1};
    static int[] dj = {0,-1,1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] grid = new int[N][N];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean[] route = new boolean[N*N + 1];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int k=0;k<4;k++){
                        int newi = i + di[k];
                        int newj = j + dj[k];
                        if(newi>=0 && newi<N && newj>=0 && newj<N){
                            if(grid[newi][newj] == grid[i][j]+1){
                                route[grid[i][j]] = true;
                                break;
                            }
                        }
                    }
                }
            }
            int start = 0;
            int max = 0;
            int sum = 1;
            for(int i=1;i<=N*N;i++){
                if(route[i]){
                    if(i==N*N){
                        if(sum>max){
                            start = i-(sum-1);
                            max = sum;
                        }
                    }
                    sum++;
                }else{
                    if(sum>max){
                        start = i-(sum-1);
                        max = sum;
                    }
                    sum = 1;
                }
            }
            bw.write("#"+t+" "+start+" "+max+"\n");

        }
        bw.close();
    }
}