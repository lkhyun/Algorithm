import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static int[][] matrix;
    static int max;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int selectTwoWidth = 0;
                int selectTwoHeight = 0;
                int selectThreeWidth = 0;
                int selectThreeHeight = 0;
                if(i+1<N){
                    selectTwoHeight = matrix[i][j]+matrix[i+1][j];
                    if(i+2<N){
                        selectThreeHeight = selectTwoHeight+matrix[i+2][j];
                    }
                }
                if(j+1<M){
                    selectTwoWidth = matrix[i][j]+matrix[i][j+1];
                    if(j+2<M){
                        selectThreeWidth = selectTwoWidth+matrix[i][j+2];
                    }
                }
                if(selectTwoHeight != 0 && selectTwoWidth != 0){
                    max = Math.max(max, selectTwoHeight+matrix[i][j+1]+matrix[i+1][j+1]);
                    if(i-1>=0){
                        max = Math.max(max, selectTwoWidth+matrix[i-1][j]+matrix[i+1][j+1]);
                        max = Math.max(max, selectTwoWidth+matrix[i-1][j+1]+matrix[i+1][j]);
                    }
                    if(j-1>=0){
                        max = Math.max(max,selectTwoHeight+matrix[i][j-1]+matrix[i+1][j+1]);
                        max = Math.max(max,selectTwoHeight+matrix[i+1][j-1]+matrix[i][j+1]);
                    }
                }
                if(selectThreeHeight != 0){
                    if(selectTwoWidth != 0){
                        max = Math.max(max, selectThreeHeight+matrix[i][j+1]);
                        max = Math.max(max, selectThreeHeight+matrix[i+1][j+1]);
                        max = Math.max(max, selectThreeHeight+matrix[i+2][j+1]);
                    }
                    if(j-1>=0){
                        max = Math.max(max,selectThreeHeight+matrix[i][j-1]);
                        max = Math.max(max,selectThreeHeight+matrix[i+1][j-1]);
                        max = Math.max(max,selectThreeHeight+matrix[i+2][j-1]);
                    }
                    if(i+3<N){
                        max = Math.max(max, selectThreeHeight+matrix[i+3][j]);
                    }
                }
                if(selectThreeWidth != 0){
                    if(selectTwoHeight != 0){
                        max = Math.max(max, selectThreeWidth+matrix[i+1][j]);
                        max = Math.max(max, selectThreeWidth+matrix[i+1][j+1]);
                        max = Math.max(max, selectThreeWidth+matrix[i+1][j+2]);
                    }
                    if(i-1>=0){
                        max = Math.max(max, selectThreeWidth+matrix[i-1][j]);
                        max = Math.max(max, selectThreeWidth+matrix[i-1][j+1]);
                        max = Math.max(max, selectThreeWidth+matrix[i-1][j+2]);
                    }
                    if(j+3<M){
                        max = Math.max(max, selectThreeWidth+matrix[i][j+3]);
                    }
                }
            }
        }
        bw.write(max+"\n");
        bw.flush();
    }

}
