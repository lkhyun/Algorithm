import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static int sharki,sharkj;
    static int sharkSize = 2;
    static int levelUp = 0;
    static int cnt = 0;
    static int[] di = {0,1,0,-1};
    static int[] dj = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    sharki=i;
                    sharkj=j;
                }
            }
        }
        while(BFS()){
        }
        bw.write(cnt+"");
        bw.close();
    }
    public static boolean BFS(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(new int[]{sharki,sharkj,0});
        visited[sharki][sharkj]=true;
        map[sharki][sharkj]=0;
        List<int[]> eat = new ArrayList<>();

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] != 9 && map[cur[0]][cur[1]]<sharkSize){ //먹을 수 있음.
                if(eat.isEmpty() || eat.get(eat.size()-1)[2]>=cur[2]){
                    eat.add(new int[]{cur[0],cur[1],cur[2]});
                }else{
                    break;
                }
            }
            for (int k = 0; k < 4; k++) {
                int newi = cur[0] + di[k];
                int newj = cur[1] + dj[k];
                if(newi<0 || newi>=N || newj<0 || newj>=N || visited[newi][newj] || map[newi][newj] > sharkSize){
                    continue;
                }
                visited[newi][newj]=true;
                q.offer(new int[]{newi,newj,cur[2]+1});
            }
        }
        if(eat.isEmpty()){
            return false;
        }
        Collections.sort(eat, (a,b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });
        sharki = eat.get(0)[0];
        sharkj = eat.get(0)[1];
        levelUp++;
        cnt += eat.get(0)[2];
        if(levelUp==sharkSize){
            sharkSize++;
            levelUp=0;
        }
        return true;
    }
}


