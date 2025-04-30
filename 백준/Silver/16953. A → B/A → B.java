import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long A,B;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        BFS();
        bw.close();
    }
    public static void BFS() throws Exception {
        ArrayDeque<long[]> q = new ArrayDeque<>();
        q.add(new long[]{A,1});
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            if (cur[0] == B) {
                bw.write(cur[1] + "\n");
                return;
            }
            if(cur[0]>B) {
                continue;
            }
            q.add(new long[]{cur[0]*2,cur[1]+1});
            String str = cur[0]+"1";
            q.add(new long[]{Long.parseLong(str),cur[1]+1});
        }
        bw.write("-1\n");
    }

}
