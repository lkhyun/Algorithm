import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> m = new HashMap<>();

        int start = 0;
        for (int i = 0; i < N; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
            if (m.size() > 2) {
                max = Math.max(max, i - start);
                while (m.size() != 2) {
                    int temp = m.get(arr[start]);
                    if (temp - 1 == 0) {
                        m.remove(arr[start]);
                    } else {
                        m.put(arr[start], temp - 1);
                    }
                    start = start + 1;
                }
            }
        }
        max = Math.max(max, N - start);

        bw.write(max + "");

        bw.close();
    }

}
