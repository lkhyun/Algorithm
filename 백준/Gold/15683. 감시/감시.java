import java.util.*;
import java.io.*;
class Node{
    int i;
    int j;
    int number;

    Node(int i, int j, int number){
        this.i = i;
        this.j = j;
        this.number = number;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[][] grid;
    static boolean[][] visited;
    static List<Node> positionCCTV = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int input = Integer.parseInt(st.nextToken());
                if(input>=1 && input<=5){
                    positionCCTV.add(new Node(i,j,input));
                    visited[i][j] = true;
                }else if(input==6) visited[i][j] = true;
                grid[i][j] = input;
            }
        }
        DFS(0,visited);
        bw.write(min+"");
        bw.close();
    }
    public static void DFS(int depth,boolean[][] visited){
        if(positionCCTV.size() == depth){
            int count = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j]) count++;
                }
            }
            min = Math.min(min,count);
            return;
        }
        boolean[][] newvisited = deepCopy2D(visited);

        Node CCTV = positionCCTV.get(depth);
        if(CCTV.number==1){
            search(CCTV.i,CCTV.j,-1,0,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            search(CCTV.i,CCTV.j,1,0,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            search(CCTV.i,CCTV.j,0,1,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            search(CCTV.i,CCTV.j,0,-1,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
        }else if(CCTV.number==2){
            search(CCTV.i,CCTV.j,-1,0,newvisited);
            search(CCTV.i,CCTV.j,1,0,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            search(CCTV.i,CCTV.j,0,-1,newvisited);
            search(CCTV.i,CCTV.j,0,1,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
        }else if(CCTV.number==3){
            search(CCTV.i,CCTV.j,-1,0,newvisited);
            search(CCTV.i,CCTV.j,0,1,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            search(CCTV.i,CCTV.j,0,1,newvisited);
            search(CCTV.i,CCTV.j,1,0,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            search(CCTV.i,CCTV.j,1,0,newvisited);
            search(CCTV.i,CCTV.j,0,-1,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            search(CCTV.i,CCTV.j,0,-1,newvisited);
            search(CCTV.i,CCTV.j,-1,0,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            
        }else if(CCTV.number==4){
            search(CCTV.i,CCTV.j,-1,0,newvisited);
            search(CCTV.i,CCTV.j,0,1,newvisited);
            search(CCTV.i,CCTV.j,1,0,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            search(CCTV.i,CCTV.j,0,1,newvisited);
            search(CCTV.i,CCTV.j,1,0,newvisited);
            search(CCTV.i,CCTV.j,0,-1,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            search(CCTV.i,CCTV.j,1,0,newvisited);
            search(CCTV.i,CCTV.j,0,-1,newvisited);
            search(CCTV.i,CCTV.j,-1,0,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            search(CCTV.i,CCTV.j,0,-1,newvisited);
            search(CCTV.i,CCTV.j,-1,0,newvisited);
            search(CCTV.i,CCTV.j,0,1,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
            
        }else if(CCTV.number==5){
            search(CCTV.i,CCTV.j,-1,0,newvisited);
            search(CCTV.i,CCTV.j,1,0,newvisited);
            search(CCTV.i,CCTV.j,0,-1,newvisited);
            search(CCTV.i,CCTV.j,0,1,newvisited);
            DFS(depth+1,newvisited);
            newvisited = deepCopy2D(visited);
        }
    }
    public static void search(int i, int j, int di, int dj, boolean[][] visited){
        visited[i][j] = true;
        int newi = i+di;
        int newj = j+dj;
        while(newi>=0&&newi<N&&newj>=0&&newj<M&&grid[newi][newj]!=6){
            visited[newi][newj] = true;
            newi += di;
            newj += dj;
        }
    }
    public static boolean[][] deepCopy2D(boolean[][] original) {
        boolean[][] copy = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }
    
}