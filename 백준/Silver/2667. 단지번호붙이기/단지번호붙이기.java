import java.util.Scanner;
import java.util.PriorityQueue;
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main{
    static int N;
    static int[][] grid;
    static boolean[][] visited;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N][N];
        sc.nextLine();

        grid = new int[N][N];
        for(int i=0;i<N;i++){
            char[] Line = sc.nextLine().toCharArray();
            for(int j=0;j<N;j++) {
                grid[i][j] = Line[j] - '0';
            }
        }
        PriorityQueue<Integer> town = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    DFS(i,j);
                    town.offer(count);
                    count = 0;
                }
            }
        }
        System.out.println(town.size());
        while(!town.isEmpty()){
            System.out.println(town.poll());
        }
        sc.close();
    }
    public static void DFS(int x,int y){
        visited[x][y] = true;
        count++;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        for(int i=0;i<4;i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if(newX>=0 && newX<N && newY>=0 && newY<N && !visited[newX][newY] && grid[newX][newY] == 1){
                DFS(newX,newY);
            }
        }
    }
}