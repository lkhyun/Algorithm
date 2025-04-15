import java.util.*;
import java.io.*;

public class Solution {

    static int N, R;
    final static long MOD = 1234567891L;

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
            R = Integer.parseInt(st.nextToken());

            long result =
                    (factorial(N) * pow((factorial(N - R) * factorial(R)) % MOD, MOD - 2)) % MOD;
            bw.write(result + "\n");
        }
        bw.close();
    }

    public static long factorial(int n) {
        long answer = 1;
        for (int i = 2; i <= n; i++) {
            answer = (answer * i) % MOD;
        }
        return answer;
    }

    public static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a % MOD;
        } else if (b % 2 == 1) { // 홀수
            return pow((a * a) % MOD, b / 2) * a % MOD;
        } else {
            return pow((a * a) % MOD, b / 2);
        }
    }
}
