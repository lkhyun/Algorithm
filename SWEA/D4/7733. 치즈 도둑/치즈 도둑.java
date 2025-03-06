import java.io.*;
import java.util.*;

class Node{
    int x;
    int y;
    Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    static int N;
    static int[][] cheeze;
    static boolean[][] visited;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            cheeze = new int[N][N];
            int max = 0;
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    cheeze[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max,cheeze[i][j]);
                }
            }
            
            int result = 1;
            for(int k = 1;k<max;k++){
                int cnt = 0;
                visited = new boolean[N][N];
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(cheeze[i][j]<=k){
                            visited[i][j] = true;
                        }
                    }
                }
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(!visited[i][j]){
                            BFS(i,j);
                            cnt++;
                        }
                    }
                }
                result = Math.max(result,cnt);
            }
            bw.write("#" + t + " " + result + "\n");
        }
        bw.close();
    }
    public static void BFS(int y,int x){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(x,y));
        visited[y][x] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0;i<4;i++){
                int newy = cur.y + dy[i];
                int newx = cur.x + dx[i];
                if(newx>=0&&newx<N&&newy>=0&&newy<N&&!visited[newy][newx]){
                    q.add(new Node(newx, newy));
                    visited[newy][newx] = true;
                }
            }
        }

    }
}
