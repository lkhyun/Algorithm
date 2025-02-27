import java.util.*;

public class Main {
    static int R,C;
    static boolean[][] grid;
    static int count = 0;
    static int[] di = {-1, 0, 1};
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        grid = new boolean[R][C];
        for(int i=0;i<R;i++){
            String str = sc.nextLine();
            for(int j=0;j<C;j++){
                if(str.charAt(j)=='.'){
                    grid[i][j] = false;
                }else{
                    grid[i][j] = true;
                }
            }
        }
        for(int i=0;i<R;i++){
            if(DFS(i, 0)) count++;
        }
        System.out.println(count);
        sc.close();
    }
    public static boolean DFS(int i, int j) {
        if (j == C - 1) {
            grid[i][j] = true;
            return true;
        }

        grid[i][j] = true;

        for (int k = 0; k < 3; k++) {
            int newi = i + di[k];
            int newj = j + 1;

            if (newi >= 0 && newi < R && newj < C && !grid[newi][newj]) {
                if(DFS(newi,newj)) return true;
            }
        }
        return false;
    }
}