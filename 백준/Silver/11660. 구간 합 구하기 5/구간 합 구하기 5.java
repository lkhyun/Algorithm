import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(i == 1 && j == 1){
                    continue;
                }else if(i == 1){
                    arr[i][j] += arr[i][j-1];
                    continue;
                }else if(j == 1) {
                    arr[i][j] += arr[i-1][j];
                    continue;
                }
                arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if(x1 == 1 && y1 == 1){
                bw.write(arr[x2][y2]+"\n");
            }else if(x1 == 1){
                bw.write(arr[x2][y2] - arr[x2][y1-1] +"\n");
            }else if(y1 == 1){
                bw.write(arr[x2][y2] - arr[x1-1][y2] + "\n");
            }else{
                bw.write(arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
