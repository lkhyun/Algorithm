import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Collection;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] house = new int[N][3];
        int[][] dp = new int[N][3];
        //초기 설정, 반복문 내내 초기일때의 조건을 확인하는 것보다 미리 넣어두고 조건문을 삭제하는게 낫다고 판단
        house[0][0] = sc.nextInt();
        house[0][1] = sc.nextInt();
        house[0][2] = sc.nextInt();
        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];

        for(int i=1;i<N;i++){
            for(int j=0;j<3;j++) {
                house[i][j] = sc.nextInt(); // 빨강, 초록, 파랑순
            }
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + house[i][2];
        }
        int minimum = Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]);
        System.out.println(minimum);
    }
}