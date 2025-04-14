import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> m = new HashMap<>();
        Set<Integer> s = new TreeSet<>();
        List<Integer> l = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            s.add(temp);
            l.add(temp);
        }
        int idx = 0;
        for (int i : s) {
            m.put(i, idx++);
        }
        for (int i : l) {
            bw.write(m.get(i) + " ");
        }
        bw.close();
    }
}
