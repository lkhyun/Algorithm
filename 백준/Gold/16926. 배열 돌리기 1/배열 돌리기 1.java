import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int layers = Math.min(N, M) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int top = layer, left = layer;
            int bottom = N - 1 - layer, right = M - 1 - layer;
            
            int len = 2 * ((bottom - top) + (right - left));
            int rotations = R % len;
            if(rotations == 0) continue;
            
            int[] ring = new int[len];
            int index = 0;

            for (int j = left; j <= right; j++) {
                ring[index++] = arr[top][j];
            }
            for (int i = top + 1; i <= bottom - 1; i++) {
                ring[index++] = arr[i][right];
            }
            for (int j = right; j >= left; j--) {
                ring[index++] = arr[bottom][j];
            }
            for (int i = bottom - 1; i >= top + 1; i--) {
                ring[index++] = arr[i][left];
            }
            
            index = 0;
            for (int j = left; j <= right; j++) {
                arr[top][j] = ring[(index + rotations) % len];
                index++;
            }
            for (int i = top + 1; i <= bottom - 1; i++) {
                arr[i][right] = ring[(index + rotations) % len];
                index++;
            }
            for (int j = right; j >= left; j--) {
                arr[bottom][j] = ring[(index + rotations) % len];
                index++;
            }
            for (int i = bottom - 1; i >= top + 1; i--) {
                arr[i][left] = ring[(index + rotations) % len];
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}