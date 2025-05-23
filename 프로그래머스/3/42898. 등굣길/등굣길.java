class Solution {
    static final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][0]][puddles[i][1]] = -1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1) continue;
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= MOD;
            }
        }
        return dp[m][n];
    }
}