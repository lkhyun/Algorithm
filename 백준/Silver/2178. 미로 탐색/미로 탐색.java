import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
        public static int BFS(int[][] grid){
            int row = grid.length;
            int column = grid[0].length;
            Queue<Point> queue = new LinkedList<>();
            
            int[] dx = {-1,0,0,1};
            int[] dy = {0,-1,1,0};

            queue.offer(new Point(0, 0));
            grid[0][0] = 0;
            while(!queue.isEmpty()){
                Point current = queue.poll();
                for(int i=0; i<4;i++){
                    int newX = current.x-dx[i];
                    int newY = current.y-dy[i];
                    if(newX>=0 && newY>=0 && newX<row && newY<column){
                        if(grid[newX][newY] == 1){
                            queue.offer(new Point(newX,newY));
                            grid[newX][newY] = grid[current.x][current.y] + 1;
                        }
                    }
                }
            }
            return grid[row-1][column-1] +1;
        }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        
        int[][] arr = new int[row][column];
        sc.nextLine();
        for(int i=0;i<row;i++){
            String Line = sc.nextLine();
            for(int j=0;j<column;j++){
                arr[i][j] = Line.charAt(j)-'0';
            }
        }
        
        System.out.println(BFS(arr));
        sc.close();
    }
}