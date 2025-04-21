import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("[\\[\\],]");

            int[] arr = new int[n];
            int count = 0;
            for (String s : str) {
                if (!s.isEmpty()) {
                    arr[count++] = Integer.parseInt(s);
                }
            }
            int start = 0;
            int end = n - 1;

            for (char c : p.toCharArray()) {
                if (count < 0)
                    break;
                if (c == 'R') {
                    int temp = start;
                    start = end;
                    end = temp;
                } else if (c == 'D') {
                    if (start < end) {
                        start++;
                    } else {
                        start--;
                    }
                    count--;
                }
            }
            if (count < 0) {
                bw.write("error\n");
                continue;
            }

            bw.write("[");
            if (count == 0) {
            } else if (start < end) {
                for (int i = start; i <= end; i++) {
                    bw.write(arr[i] + "");
                    if (i != end)
                        bw.write(",");
                }
            } else {
                for (int i = start; i >= end; i--) {
                    bw.write(arr[i] + "");
                    if (i != end)
                        bw.write(",");
                }
            }
            bw.write("]\n");
        }

        bw.close();
    }
}
