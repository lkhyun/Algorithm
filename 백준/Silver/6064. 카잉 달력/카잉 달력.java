import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int M, N, x, y;
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int answer;
            if (x < y) {
                answer = calender(x, y, M, N);
            } else {
                answer = calender(y, x, N, M);
            }

            bw.write(answer + "\n");
        }
        bw.close();
    }

    public static int calender(int min, int max, int minMOD, int maxMOD) {
        boolean[] visited = new boolean[maxMOD];
        int cnt = min;
        int temp = min - 1;
        while (temp != max - 1) {
            temp = (temp + minMOD) % maxMOD;
            if (visited[temp]) {
                cnt = -1;
                break;
            }
            visited[temp] = true;
            cnt += minMOD;
        }
        return cnt;
    }
}


