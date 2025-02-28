import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int n = arr.length/2 + 1;
        int[][] maxdp = new int[n][n];
        int[][] mindp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(maxdp[i],Integer.MIN_VALUE/2);
            Arrays.fill(mindp[i],Integer.MAX_VALUE/2);
        }
        for(int i=0;i<n;i++){
            maxdp[i][i] = Integer.parseInt(arr[i*2]);
            mindp[i][i] = Integer.parseInt(arr[i*2]);
        }
        for(int i=1;i<n;i++){//구간
            for(int j=0;j<n-i;j++){//시작점
                for(int k=j;k<j+i;k++){//경유점
                    if(arr[2*k + 1].equals("+")){
                        maxdp[j][j+i] = Math.max(maxdp[j][k] + maxdp[k+1][j+i],maxdp[j][j+i]);
                        mindp[j][j+i] = Math.min(mindp[j][k] + mindp[k+1][j+i],mindp[j][j+i]);
                    }else{
                        maxdp[j][j+i] = Math.max(maxdp[j][k] - mindp[k+1][j+i],maxdp[j][j+i]);
                        mindp[j][j+i] = Math.min(mindp[j][k] - maxdp[k+1][j+i],mindp[j][j+i]);
                    }
                }
            }
        }
        return maxdp[0][n-1];
    }
}