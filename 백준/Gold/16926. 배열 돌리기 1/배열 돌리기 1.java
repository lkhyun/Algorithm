import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int R = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] row = new int[M];
            for (int j = 0; j < M; j++) {
                row[j] = Integer.parseInt(st.nextToken());
            }
            arr[i] = row;
        }
        
        final int layers = Math.min(N, M) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int top = layer, left = layer;
            int bottom = N - 1 - layer, right = M - 1 - layer;
            
            int perim = 2 * ((bottom - top) + (right - left));
            if (perim == 0) continue;
            int r = R % perim;
            if (r == 0) continue;
            
            int[] ring = new int[perim];
            int idx = 0;
            for (int j = left; j <= right; j++) {
                ring[idx++] = arr[top][j];
            }
            for (int i = top + 1; i <= bottom - 1; i++) {
                ring[idx++] = arr[i][right];
            }
            for (int j = right; j >= left; j--) {
                ring[idx++] = arr[bottom][j];
            }
            for (int i = bottom - 1; i >= top + 1; i--) {
                ring[idx++] = arr[i][left];
            }

            int[] rotated = new int[perim];
            System.arraycopy(ring, r, rotated, 0, perim - r);
            System.arraycopy(ring, 0, rotated, perim - r, r);
            idx = 0;
            for (int j = left; j <= right; j++) {
                arr[top][j] = rotated[idx++];
            }
            for (int i = top + 1; i <= bottom - 1; i++) {
                arr[i][right] = rotated[idx++];
            }
            for (int j = right; j >= left; j--) {
                arr[bottom][j] = rotated[idx++];
            }
            for (int i = bottom - 1; i >= top + 1; i--) {
                arr[i][left] = rotated[idx++];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int[] row = arr[i];
            for (int j = 0; j < M; j++) {
                sb.append(row[j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}