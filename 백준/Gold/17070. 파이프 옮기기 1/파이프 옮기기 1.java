import java.util.Scanner;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] matrix;
    static int count = 0;
    static int N;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        matrix = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        DFS(new Point(0,0),new Point(0,1));
        System.out.println(count);
    }
    static void DFS(Point tail, Point head){
        if(head.x == N-1 && head.y == N-1){
            count++;
            return;
        }
        boolean right = head.y+1<N && matrix[head.x][head.y+1]==0;
        boolean down = head.x+1<N && matrix[head.x+1][head.y]==0;
        boolean diagonal = right && down && matrix[head.x+1][head.y+1]==0;
        if(head.x == tail.x && head.y-tail.y == 1){//가로
            if(right){//오른쪽 여분 공간 있을때
                DFS(new Point(head.x,head.y),new Point(head.x,head.y+1));//오른쪽 이동
            }
            if(diagonal){//아래 여분 공간 있을때
                DFS(new Point(head.x,head.y),new Point(head.x+1,head.y+1));//대각선 이동동
            }
        }
        else if(head.x - tail.x == 1 && head.y == tail.y){//세로
            if(down){//아래 여분 공간 있을때
                DFS(new Point(head.x,head.y),new Point(head.x+1,head.y));
            }
            if(diagonal){//오른쪽 여분 공간 있을때
                DFS(new Point(head.x,head.y),new Point(head.x+1,head.y+1));
            }
        }
        else{//대각선
            if(right){
                DFS(new Point(head.x,head.y),new Point(head.x,head.y+1));
            }
            if(down){
                DFS(new Point(head.x,head.y),new Point(head.x+1,head.y));
            }
            if(diagonal){
                DFS(new Point(head.x,head.y),new Point(head.x+1,head.y+1));
            }
        }
    }
}
