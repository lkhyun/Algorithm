import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, r, c;
    static int cnt = 0;
    static int ans;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int arrLen = (int) Math.pow(2, N);

        search(0, 0, arrLen);
        bw.write(ans + "");
        bw.close();
    }

    public static void search(int starti, int startj, int size) {
        if (size == 1) {
            if (starti == r && startj == c)
                ans = cnt;
            cnt++;
            return;
        }

        int newsize = size / 2;
        int adder = newsize * newsize;
        if (r < (starti + newsize)) {// 위
            if (c < (startj + newsize)) {// 왼쪽
                search(starti, startj, newsize);
            } else {// 오른쪽
                cnt += adder;
                search(starti, startj + newsize, newsize);
            }
        } else {// 아래
            if (c < (startj + newsize)) {// 왼쪽
                cnt += adder * 2;
                search(starti + newsize, startj, newsize);
            } else {// 오른쪽
                cnt += adder * 3;
                search(starti + newsize, startj + newsize, newsize);
            }
        }
    }

}


