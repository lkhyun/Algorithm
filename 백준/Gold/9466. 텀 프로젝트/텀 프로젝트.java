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
            for (int i = 1; i <= n; i++) { // 매 인원마다 체크
                if(visited[i]) continue; // 한번이라도 거쳐갔다면 넘어감
                int cur = want[i];
                List<Integer> temp = new ArrayList<>();
                temp.add(i); //현재 인원을 리스트에 넣고
                visited[i] = true; //다녀감 체크
                while(!visited[cur]) { //순회하지 않은 경우만 돌음
                    temp.add(cur);
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