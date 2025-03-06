import java.util.*;
import java.io.*;


class Node{
    int x;
    int y;
    Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class Main
{
    static int R;
    static int C;
    static char[][] board;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static int total = 0;
    static boolean[][] visited;
    static Map<Character,Boolean> visitedAlphabet = new HashMap<>();

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for(int i=0;i<R;i++){
            char[] str = br.readLine().toCharArray();
            for(int j=0;j<C;j++){
                board[i][j] = str[j];
            }
        }
        visited = new boolean[R][C];

        visited[0][0] = true;
        visitedAlphabet.put(board[0][0], true);
        BFS(0,0,1);
        bw.write(total+"");
        bw.close();
    }
    public static void BFS(int x, int y, int depth){
        for(int k = 0;k<4;k++){
            int newx = x + dx[k];
            int newy = y + dy[k];
            if(newx>=0&&newx<C&&newy>=0&&newy<R&&!visited[newy][newx]){
                boolean flag = visitedAlphabet.getOrDefault(board[newy][newx], false);
                if(!flag){
                    visited[newy][newx] = true;
                    visitedAlphabet.put(board[newy][newx],true);
                    BFS(newx,newy,depth+1);
                    visited[newy][newx] = false;
                    visitedAlphabet.put(board[newy][newx],false);
                }
            }
        }
        total = Math.max(total,depth);
    }
}