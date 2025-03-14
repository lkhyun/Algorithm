import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Map<Integer,List<Integer>> info;
    static int cnt = 0;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        info = new HashMap<>();
        visited = new boolean[N+1];
        int M = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            List<Integer> temp = info.getOrDefault(from, new ArrayList<>());
            temp.add(to);
            info.put(from, temp);
            temp = info.getOrDefault(to, new ArrayList<>());
            temp.add(from);
            info.put(to, temp);
        }
        DFS(1);
        bw.write((cnt-1)+"");
        bw.close();
    }
    public static void DFS(int cur){
        cnt++;
        visited[cur] = true;
        List<Integer> temp = info.getOrDefault(cur,null);
        if (temp != null) {
            for (int i : temp) {
                if(!visited[i]) DFS(i);
            }
        }
    }
}
