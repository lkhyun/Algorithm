import java.io.BufferedInputStream;
import java.io.IOException;

public class Main {

    static final int BUFFER_SIZE = 1 << 16;
    static BufferedInputStream bis = new BufferedInputStream(System.in, BUFFER_SIZE);

    static byte[] inBuffer = new byte[BUFFER_SIZE];
    static int inIndex, inSize;

    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int M = nextInt();
        int R = nextInt();

        int[][] arr = new int[N][M];

        // 행렬 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = nextInt();
            }
        }

        int numRings = Math.min(N, M) / 2;
        for (int ring = 0; ring < numRings; ring++) {
            int rowStart = ring, rowEnd = N - 1 - ring;
            int colStart = ring, colEnd = M - 1 - ring;

            int height = (rowEnd - rowStart + 1);
            int width = (colEnd - colStart + 1);
            int elements = 2 * (height + width - 2);

            // 실제 회전 횟수
            int actualR = R % elements;
            if (actualR == 0) continue;

            // 링의 요소들을 임시 배열에 저장
            int[] temp = new int[elements];
            int t = 0;

            // 상단 행 (왼 -> 오)
            for (int j = colStart; j < colEnd; j++) {
                temp[t++] = arr[rowStart][j];
            }
            // 오른쪽 열 (위 -> 아래)
            for (int i = rowStart; i < rowEnd; i++) {
                temp[t++] = arr[i][colEnd];
            }
            // 하단 행 (오 -> 왼)
            for (int j = colEnd; j > colStart; j--) {
                temp[t++] = arr[rowEnd][j];
            }
            // 왼쪽 열 (아래 -> 위)
            for (int i = rowEnd; i > rowStart; i--) {
                temp[t++] = arr[i][colStart];
            }

            // temp배열에서 actualR부터 읽어오도록 세팅
            t = actualR;

            // 상단 행 (왼 -> 오)
            for (int j = colStart; j < colEnd; j++) {
                arr[rowStart][j] = temp[t];
                t = (t + 1) % elements;
            }
            // 오른쪽 열 (위 -> 아래)
            for (int i = rowStart; i < rowEnd; i++) {
                arr[i][colEnd] = temp[t];
                t = (t + 1) % elements;
            }
            // 하단 행 (오 -> 왼)
            for (int j = colEnd; j > colStart; j--) {
                arr[rowEnd][j] = temp[t];
                t = (t + 1) % elements;
            }
            // 왼쪽 열 (아래 -> 위)
            for (int i = rowEnd; i > rowStart; i--) {
                arr[i][colStart] = temp[t];
                t = (t + 1) % elements;
            }
        }

        // 결과를 모아서 출력 (StringBuilder 사용)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    /** 빠른 입력 메서드들 */
    static int nextInt() throws IOException {
        int c;
        // 공백류 스킵
        do {
            c = read();
            if (c == -1) return -1; 
        } while (c <= ' ');

        boolean negative = (c == '-');
        if (negative) {
            c = read();
        }

        int val = 0;
        while (c >= '0' && c <= '9') {
            val = (val << 3) + (val << 1) + (c & 15); // val * 10 + (c - '0')
            c = read();
        }
        return negative ? -val : val;
    }

    static int read() throws IOException {
        if (inIndex == inSize) {
            inSize = bis.read(inBuffer, 0, BUFFER_SIZE);
            if (inSize == -1) return -1;
            inIndex = 0;
        }
        return inBuffer[inIndex++] & 0xFF;
    }
}