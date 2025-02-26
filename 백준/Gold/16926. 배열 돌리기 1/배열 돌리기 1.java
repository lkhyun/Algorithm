import java.io.*;

public class Main {
    private static final int BUFFER_SIZE = 1 << 16;
    private static DataInputStream din = new DataInputStream(System.in);
    private static byte[] buffer = new byte[BUFFER_SIZE];
    private static int bufferPointer = 0, bytesRead = 0;
    
    public static void main(String[] args) throws Exception {
        int N = nextInt();
        int M = nextInt();
        int R = nextInt();
        
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                arr[i][j] = nextInt();
            }
        }
        
        int layers = Math.min(N, M) / 2;
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
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    
    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) {
            c = read();
        }
        do {
            ret = ret * 10 + (c - '0');
        } while ((c = read()) >= '0' && c <= '9');
        return neg ? -ret : ret;
    }
    
    private static byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
    
    private static void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
        bufferPointer = 0;
    }
}