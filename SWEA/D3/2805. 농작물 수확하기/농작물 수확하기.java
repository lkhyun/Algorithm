import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] farm = new int[N][N];
            sc.nextLine();
            for (int i = 0; i < N; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = Character.getNumericValue(str.charAt(j));
                }
            }
            int sum = 0;

            for(int i=0;i<N;i++){
                int k = Math.min(i,N-i-1);
                for(int j=(N/2)-k;j<=(N/2)+k;j++){
                    sum += farm[i][j];
                }
            }
            System.out.println("#"+t+" "+sum);
        }
        
    }
}