import java.io.InputStream;
import java.io.IOException;

public class Main {
    static final int BUF_SIZE = 1 << 20; // 입출력 버퍼 크기 (1MB)
    static final InputStream in = System.in;
    static final byte[] inBuff = new byte[BUF_SIZE];
    static int inPos, inCount;

    static final byte[] outBuff = new byte[BUF_SIZE];
    static int outPos;

    // 숫자 -> 문자 변환용 임시 버퍼 (최대 int 길이 + 음수 = 11자 정도)
    static final byte[] numBuff = new byte[11];

    static int[] matrix;       // NxM 전체를 1차원으로 저장
    static int[] ringBuf;      // 링 추출용 임시 배열 (최대 둘레 크기)
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        N = nextInt();
        M = nextInt();
        R = nextInt();

        matrix = new int[N * M];

        // 행렬 입력
        for(int i=0;i<N;i++){
            int base = i*M;
            for(int j=0;j<M;j++){
                matrix[base+j] = nextInt();
            }
        }

        // 가장 바깥쪽 링의 둘레(최대 길이): 2*(N + M - 2)
        // (N==1 또는 M==1 인 경우를 제외하면)
        int maxRingSize = 2*((N)+(M)-2);
        if(maxRingSize < 0) maxRingSize = 0; // 혹시 N=1,M=1일 때 예외처리
        ringBuf = new int[maxRingSize];

        int rings = (Math.min(N, M))/2;
        for(int ring=0; ring<rings; ring++){
            int top = ring;
            int left = ring;
            int bottom = N-1-ring;
            int right = M-1-ring;

            int height = bottom - top + 1;    // 해당 링 높이
            int width = right - left + 1;     // 해당 링 너비
            int elems = (height + width - 2)*2; // 둘레 원소 수

            if(elems <= 0) continue;

            int shift = R % elems;
            if(shift == 0) continue;

            // 1) 링 추출 -> ringBuf
            int idx=0;
            // 윗줄 (left→right)
            int row=top, col;
            for(col=left; col<right; col++){
                ringBuf[idx++] = matrix[row*M + col];
            }
            // 오른쪽 열 (top→bottom)
            for(row=top; row<bottom; row++){
                ringBuf[idx++] = matrix[row*M + right];
            }
            // 아랫줄 (right→left)
            for(col=right; col>left; col--){
                ringBuf[idx++] = matrix[bottom*M + col];
            }
            // 왼쪽 열 (bottom→top)
            for(row=bottom; row>top; row--){
                ringBuf[idx++] = matrix[row*M + left];
            }

            // 2) ringBuf를 shift만큼 회전(앞에서 actualR개 떼어 뒤로 붙이는 효과)
            // => temp[ (i + shift) % elems ]
            // 여기서는 '읽을 시작점'을 shift로 잡아 그대로 써내려가는 방식
            idx = shift;

            // 3) 다시 원본 matrix에 덮어씀
            // 윗줄
            row = top;
            for(col=left; col<right; col++){
                matrix[row*M + col] = ringBuf[idx];
                idx = (idx+1 == elems)? 0 : idx+1;
            }
            // 오른쪽 열
            for(row=top; row<bottom; row++){
                matrix[row*M + right] = ringBuf[idx];
                idx = (idx+1 == elems)? 0 : idx+1;
            }
            // 아랫줄
            for(col=right; col>left; col--){
                matrix[bottom*M + col] = ringBuf[idx];
                idx = (idx+1 == elems)? 0 : idx+1;
            }
            // 왼쪽 열
            for(row=bottom; row>top; row--){
                matrix[row*M + left] = ringBuf[idx];
                idx = (idx+1 == elems)? 0 : idx+1;
            }
        }

        // 결과 출력
        // 각 행을 돌면서 matrix[i*M + j]를 변환 -> outBuff 에 쓰기
        for(int i=0;i<N;i++){
            int base = i*M;
            for(int j=0;j<M;j++){
                writeInt(matrix[base+j]);
                writeSpace();
            }
            writeNewLine();
        }
        flush();
    }

    /* ========= 빠른 입력 ========== */
    static int read() throws IOException {
        if(inPos == inCount){
            inCount = in.read(inBuff, 0, BUF_SIZE);
            if(inCount == -1) return -1;
            inPos = 0;
        }
        return inBuff[inPos++] & 0xFF;
    }

    static int nextInt() throws IOException {
        int c;
        do {
            c = read();
            if(c == -1) return -1; // EOF
        } while(c <= ' ');
        boolean neg = (c == '-');
        if(neg) c = read();
        int val = 0;
        while(true){
            if(c < '0' || c > '9') break;
            val = (val << 3) + (val << 1) + (c & 15);
            c = read();
        }
        return neg ? -val : val;
    }

    /* ========= 빠른 출력 ========== */
    static void writeInt(int x) {
        if(x==0){
            writeByte((byte)'0');
            return;
        }
        if(x<0){
            writeByte((byte)'-');
            x = -x;
        }
        int pos=0;
        while(x>0){
            numBuff[pos++]=(byte)((x%10)+'0');
            x/=10;
        }
        while(pos-->0){
            writeByte(numBuff[pos]);
        }
    }

    static void writeSpace() {
        writeByte((byte)' ');
    }

    static void writeNewLine() {
        writeByte((byte)'\n');
    }

    static void writeByte(byte b) {
        outBuff[outPos++] = b;
        if(outPos==BUF_SIZE){
            System.out.write(outBuff,0,BUF_SIZE);
            outPos=0;
        }
    }

    static void flush(){
        if(outPos>0){
            System.out.write(outBuff,0,outPos);
        }
    }
}