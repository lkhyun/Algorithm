import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] want;
    static boolean[] visited;
    static int noTeamCnt;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            want = new int[n+1];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                want[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[n+1];
            noTeamCnt = 0;
            for (int i = 1; i <= n; i++) {
                if(visited[i]) continue;
                int cur = want[i];
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                visited[i] = true;
                while(!visited[cur]) {
                    temp.add(cur);
                    if(visited[cur]) break;
                    visited[cur] = true;
                    cur = want[cur];
                }
                int curPos = temp.indexOf(cur);
                if(curPos == -1){
                    noTeamCnt += temp.size();
                }else{
                    noTeamCnt += curPos;
                }
            }
            bw.write(noTeamCnt + "\n");
        }
        bw.close();
    }
}