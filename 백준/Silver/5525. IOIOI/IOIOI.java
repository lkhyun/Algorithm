import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int M;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        M = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        char[] pattern = new char[2 * N + 1];
        for (int i = 0; i < pattern.length; i++) {
            if (i % 2 == 0)
                pattern[i] = 'I';
            else
                pattern[i] = 'O';
        }

        int[] p = new int[2 * N + 1];

        for (int i = 1, j = 0; i < pattern.length; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = p[j - 1];
            }

            if (pattern[i] == pattern[j]) {
                p[i] = ++j;
            } else {
                p[i] = 0;
            }
        }

        for (int i = 0, j = 0; i < str.length; i++) {
            while (j > 0 && str[i] != pattern[j]) {
                j = p[j - 1];
            }

            if (str[i] == pattern[j]) {
                if (j == pattern.length - 1) {
                    cnt++;
                    j = p[j];
                } else {
                    j++;
                }
            }
        }
        bw.write(cnt + "");
        bw.close();
    }
}
