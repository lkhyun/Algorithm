import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static Map<Integer,Integer> ladder;
    static Map<Integer,Integer> snake;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ladder = new HashMap<>();
        snake = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            ladder.put(from,to);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            snake.put(from,to);
        }

        BFS();
        bw.write(cnt+"");
        bw.close();
    }
    public static void BFS(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        boolean[] visited = new boolean[101];
        pq.add(new int[]{1,0});
        visited[0] = true;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            visited[cur[0]] = true;
            if(cur[0] == 100){
                cnt = cur[1];
                break;
            }
            if(ladder.containsKey(cur[0])){
                pq.add(new int[]{ladder.get(cur[0]),cur[1]});
                continue;
            }else if(snake.containsKey(cur[0])) {
                pq.add(new int[]{snake.get(cur[0]), cur[1]});
                continue;
            }
            for (int i = 1; i <= 6; i++) {
                int next = cur[0]+i;
                if(next>100 || visited[next]) continue;
                pq.add(new int[]{next,cur[1]+1});
            }
        }
    }
}
