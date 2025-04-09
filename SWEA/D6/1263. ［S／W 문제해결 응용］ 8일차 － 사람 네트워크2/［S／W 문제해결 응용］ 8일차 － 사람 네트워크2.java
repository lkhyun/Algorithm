import java.util.*;
import java.io.*;

public class Solution {

    static int N;
    static int[][] matrix;
    static int min;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            bw.write("#" + t + " ");
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            matrix = new int[N][N];
            min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 1) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = Integer.MAX_VALUE / 2;
                    }
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = Math.min(matrix[i][k] + matrix[k][j], matrix[i][j]);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                int cc = 0;
                for (int j = 0; j < N; j++) {
                    if (i == j)
                        continue;
                    cc += matrix[i][j];
                }
                min = Math.min(min, cc);
            }
            bw.write(min + "\n");
        }
        bw.close();
    }
}
