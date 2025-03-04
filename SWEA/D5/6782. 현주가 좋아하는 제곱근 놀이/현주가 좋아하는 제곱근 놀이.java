import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            bw.write("#" + t + " ");
            
            long N = Long.parseLong(br.readLine().trim());

            if (N == 2) {
                bw.write("0\n");
                continue;
            }

            int cnt = 0;
            while (N != 2) {
                if (isPerfectSquare(N)) {
                    N = (long) Math.sqrt(N);
                    cnt++;
                } else {
                    long temp = N;
                    N = nextPerfectSquare(N); // 다음 제곱수로 점프
                    cnt += N-temp;
                }
                
            }
            bw.write(cnt + "\n");
        }
        bw.close();
    }

    // 제곱수 판별
    public static boolean isPerfectSquare(long num) {
        if (num < 1) return false;
        long sqrt = (long) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    // 가장 가까운 다음 제곱수를 찾는 함수
    public static long nextPerfectSquare(long num) {
        long sqrt = (long) Math.sqrt(num);
        return (sqrt + 1) * (sqrt + 1);
    }
}
