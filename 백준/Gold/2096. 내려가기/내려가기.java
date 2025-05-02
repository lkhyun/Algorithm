import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][][] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            arr[i][0][0] = left;
            arr[i][0][1] = left;
            arr[i][1][0] = mid;
            arr[i][1][1] = mid;
            arr[i][2][0] = right;
            arr[i][2][1] = right;
            if(i != 0){
                arr[i][0][0] += Math.max(arr[i-1][0][0],arr[i-1][1][0]);
                arr[i][0][1] += Math.min(arr[i-1][0][1],arr[i-1][1][1]);

                int tempmax = Math.max(arr[i-1][0][0],arr[i-1][1][0]);
                arr[i][1][0] += Math.max(tempmax,arr[i-1][2][0]);
                int tempmin = Math.min(arr[i-1][0][1],arr[i-1][1][1]);
                arr[i][1][1] += Math.min(tempmin,arr[i-1][2][1]);

                arr[i][2][0] += Math.max(arr[i-1][1][0],arr[i-1][2][0]);
                arr[i][2][1] += Math.min(arr[i-1][1][1],arr[i-1][2][1]);
            }
        }
        int tempmax = Math.max(arr[N-1][0][0],arr[N-1][1][0]);
        int tempmin = Math.min(arr[N-1][0][1],arr[N-1][1][1]);
        bw.write(Math.max(tempmax,arr[N-1][2][0])+" "+Math.min(tempmin,arr[N-1][2][1])+"\n");
        bw.close();
    }
}