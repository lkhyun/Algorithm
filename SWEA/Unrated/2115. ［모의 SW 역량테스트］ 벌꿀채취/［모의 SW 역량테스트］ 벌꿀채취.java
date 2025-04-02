import java.util.*;
import java.io.*;

public class Solution{
    static int N;
    static int M;
    static int C;
    static int[][] matrix;
    static int[][] honeysum;
    static int max;
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1;t<=T;t++){
            bw.write("#"+t+" ");

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            matrix = new int[N][N];
            honeysum = new int[N][N-M+1];
            
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
            int[] temp = new int[M];
            for(int i=0;i<N;i++){
                for(int j=0;j<=N-M;j++){
                    for(int k=0;k<M;k++){
                        temp[k] = matrix[i][j+k];
                    }
                    max = 0;
                    backtracking(0,0,0,0,temp);
                    honeysum[i][j] = max;
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<=N-M;j++){
                    for(int k=j+M;k<=N-M;k++){
                        pq.add(honeysum[i][j]+honeysum[i][k]);
                    }
                    for(int k=i+1;k<N;k++){
                        for(int l=0;l<=N-M;l++){
                            pq.add(honeysum[i][j]+honeysum[k][l]);
                        }
                    }
                }
            }
            bw.write(pq.poll()+"\n");
        }
        bw.close();
    }
    public static void backtracking(int start,int depth, int sum, int pow, int[] temp){
        if(sum > C) return;
        if(depth > M) return;
        max = Math.max(max,pow);

        for(int i=start;i<M;i++){
            backtracking(i+1,depth+1,sum+temp[i],pow+(temp[i]*temp[i]),temp);
        }
    }
}