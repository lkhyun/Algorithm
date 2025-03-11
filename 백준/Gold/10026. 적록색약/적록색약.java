import java.util.*;
import java.io.*;

class Node{
    int y;
    int x;

    Node(int y,int x){
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int N;
    static int[][] normalGrid;
    static int[][] abnormalGrid;
    static int abnormalSection = 0;
    static int normalSection = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        normalGrid = new int[N][N];
        abnormalGrid = new int[N][N];
        for(int i=0;i<N;i++){
            String temp = br.readLine();
            for(int j=0;j<N;j++){                  
                if(temp.charAt(j) == 'R'){
                    normalGrid[i][j] = 0;
                    abnormalGrid[i][j] = 0;
                }else if(temp.charAt(j) == 'G'){
                    normalGrid[i][j] = 1;
                    abnormalGrid[i][j] = 0;
                }else if(temp.charAt(j) == 'B'){
                    normalGrid[i][j] = 2;
                    abnormalGrid[i][j] = 2;
                }
            }
        }
        boolean[][] visited = new boolean[N][N];
        boolean[][] abvisited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    BFS(i,j,visited,normalGrid[i][j],0);
                    normalSection++;
                }
                if(!abvisited[i][j]){
                    BFS(i,j,abvisited,abnormalGrid[i][j],1);
                    abnormalSection++;
                }
            }
        }
        System.out.println(normalSection + " " + abnormalSection);
    }
    public static void BFS(int y, int x, boolean[][] visited, int color, int option){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(y, x));
        visited[y][x] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int k=0;k<4;k++){
                int newx = cur.x + dx[k];
                int newy = cur.y + dy[k];
                if(newx>=0&&newx<N&&newy>=0&&newy<N&&!visited[newy][newx]){
                    if((option==0&&normalGrid[newy][newx]==color) || (option==1&&abnormalGrid[newy][newx]==color)){
                        q.add(new Node(newy, newx));
                        visited[newy][newx] = true;
                    }
                }
            }
        }
    }
}
