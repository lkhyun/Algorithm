import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static int[][] matrix;
    static Map<String,String> parent;
    static Map<String,Integer> dp;
    static int[] di = {0,0,-1,1};
    static int[] dj = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }

        // 모여있는 0들 찾기
        parent = new HashMap<>();
        dp = new HashMap<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j] == 0 && !visited[i][j]){
                    BFS(i,j,visited);
                }
            }
        }

        //1인 곳마다 인접하고 있는 0 그룹들 더해주기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix[i][j] == 1){
                    List<String> added = new ArrayList<>();
                    for (int k = 0; k < 4; k++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];
                        if(ni<0 || ni>=N || nj<0 || nj>=M) continue;
                        if(matrix[ni][nj] == 0){
                            String cur = ni+" "+nj;
                            String root = parent.get(cur);
                            if(added.contains(root)) continue;
                            matrix[i][j] += dp.get(root);
                            added.add(root);
                        }
                    }
                    if(matrix[i][j] % 10 != 0){
                        sb.append(matrix[i][j]%10);
                    }else{
                        sb.append("0");
                    }
                }else{
                    sb.append("0");
                }
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.close();
    }
    static void BFS(int i, int j, boolean[][] visited){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;

        String start = i+" "+j;
        int cnt = 0;

        parent.put(start,start);

        while(!q.isEmpty()){
            int[] cur = q.poll();
            cnt++;

            for (int k = 0; k < 4; k++) {
                int ni = cur[0] + di[k];
                int nj = cur[1] + dj[k];

                if(ni<0 || ni>=N || nj<0 || nj>=M || visited[ni][nj]) continue;

                if(matrix[ni][nj] == 0){
                    visited[ni][nj] = true;
                    parent.put(ni+" "+nj, start);
                    q.add(new int[]{ni,nj});
                }
            }
        }
        dp.put(start,cnt);
    }
}
