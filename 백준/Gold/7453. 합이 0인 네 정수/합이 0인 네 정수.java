import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] A;
    static int[] B;
    static int[] C;
    static int[] D;
    static int[] AB;
    static int[] CD;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        AB = new int[N*N];
        CD = new int[N*N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[i*N+j] = A[i] + B[j];
                CD[i*N+j] = C[i] + D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);

        int left = 0, right = N*N-1;
        while (left < N*N && right >= 0) {
            if(AB[left] + CD[right] == 0){
                int leftCnt = 1;
                while(left + 1 < N*N && AB[left+1] == AB[left]){
                    left++;
                    leftCnt++;
                }
                int rightCnt = 1;
                while(right - 1 >= 0 && CD[right-1] == CD[right]){
                    right--;
                    rightCnt++;
                }
                answer += (long)leftCnt * rightCnt;
                left++;
                right--;
            }else if(AB[left] + CD[right] < 0){
                left++;
            }else{
                right--;
            }
        }
        bw.write(answer + "\n");
        bw.close();
    }
}