import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int R,C,T;
    static int[][] matrix;
    static int[] cleaner = new int[2];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        matrix = new int[R+1][C+1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j] == -1){ //공기청정기 위치
                    if(cleaner[0] != 0){
                        cleaner[1] = i;
                    }else{
                        cleaner[0] = i;
                    }
                }
            }
        }
        for (int t = 1; t <= T; t++) {
            int[][] temp = new int[R+1][C+1];
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if(matrix[i][j] != -1){
                        int div = matrix[i][j]/5;
                        int cnt = 0;
                        if(j+1<=C && matrix[i][j+1] != -1) {
                            temp[i][j+1] += div;
                            cnt++;
                        }
                        if(i+1<=R && matrix[i+1][j] != -1) {
                            temp[i+1][j] += div;
                            cnt++;
                        }
                        if(j-1>=1 && matrix[i][j-1] != -1) {
                            temp[i][j-1] += div;
                            cnt++;
                        }
                        if(i-1>=1 && matrix[i-1][j] != -1){
                            temp[i-1][j] += div;
                            cnt++;
                        }
                        temp[i][j] += matrix[i][j] - div*cnt;
                    }
                }
            }
            temp[cleaner[0]][1] = -1;
            temp[cleaner[1]][1] = -1;
            clean(temp);
            for (int i = 1; i <= R; i++) {
                matrix[i] = Arrays.copyOf(temp[i], C+1);
            }
        }

        int total = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if(matrix[i][j] != -1){
                    total += matrix[i][j];
                }
            }
        }
        bw.write(total+"\n");
        bw.close();
    }
    public static void clean(int[][] matrix){
        //위쪽 정화
        int curi = cleaner[0];
        int curj = 1;
        while(--curi >= 1){
            if(matrix[curi+1][curj] != -1){
                matrix[curi+1][curj] = matrix[curi][curj];
            }
        }
        curi = 1;
        while(++curj <= C){
            matrix[curi][curj-1] = matrix[curi][curj];
        }
        curj = C;
        while(++curi <= cleaner[0]){
            matrix[curi-1][curj] = matrix[curi][curj];
        }
        curi = cleaner[0];
        while(--curj >= 1){
            if(matrix[curi][curj] != -1){
                matrix[curi][curj+1] = matrix[curi][curj];
            }else{
                matrix[curi][curj+1] = 0;
            }
        }
        //아래쪽 정화
        curi = cleaner[1];
        curj = 1;
        while(++curi<=R){
            if(matrix[curi-1][curj] != -1){
                matrix[curi-1][curj] = matrix[curi][curj];
            }
        }
        curi = R;
        while(++curj<=C){
            matrix[curi][curj-1] = matrix[curi][curj];
        }
        curj = C;
        while(--curi>=cleaner[1]){
            matrix[curi+1][curj] = matrix[curi][curj];
        }
        curi = cleaner[1];
        while(--curj>=1){
            if(matrix[curi][curj] != -1){
                matrix[curi][curj+1] = matrix[curi][curj];
            }else{
                matrix[curi][curj+1] = 0;
            }
        }
    }

}

