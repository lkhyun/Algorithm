import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];
        long[][][] dp = new long[3][N][N]; // 0:가로 1:세로 2:대각선선
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i=1;i<N;i++){
            if(matrix[0][i] == 1){
                break;
            }
            dp[0][0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if(matrix[i][j] == 1){
                    dp[0][i][j] = 0;
                    dp[1][i][j] = 0;
                    dp[2][i][j] = 0;
                }
                else{
                    boolean left = matrix[i][j-1] == 0;
                    boolean up = matrix[i-1][j] == 0;
                    boolean diagonal = matrix[i-1][j-1] == 0;
                    if(left&&up&&diagonal){
                        dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1];
                        dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j];
                        dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
                    }
                    else if(left&&diagonal){
                        dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1];
                        dp[1][i][j] = 0;
                        dp[2][i][j] = 0;
                    }
                    else if(diagonal&&up){
                        dp[0][i][j] = 0;
                        dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j];
                        dp[2][i][j] = 0;
                    }
                    else if(left&&up){
                        dp[0][i][j] = dp[0][i][j-1];
                        dp[1][i][j] = dp[1][i-1][j];
                        dp[2][i][j] = 0;
                    }
                    else if(left){
                        dp[0][i][j] = dp[0][i][j-1];
                        dp[1][i][j] = 0;
                        dp[2][i][j] = 0;
                    }
                    else if(up){
                        dp[0][i][j] = 0;
                        dp[1][i][j] = dp[1][i-1][j];
                        dp[2][i][j] = 0;
                    }
                    else{
                        dp[0][i][j] = 0;
                        dp[1][i][j] = 0;
                        dp[2][i][j] = 0;
                    }
                }
            }
        }

        System.out.println(dp[0][N-1][N-1]+dp[1][N-1][N-1]+dp[2][N-1][N-1]);
    }
}
