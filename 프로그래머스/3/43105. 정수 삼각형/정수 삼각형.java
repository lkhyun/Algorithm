import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int depth = triangle.length;
        int max = 0;
        for(int i=1;i<depth;i++){
            for(int j=0;j<triangle[i].length;j++){
                int left = triangle[i][j];
                int right = triangle[i][j];
                if(triangle[i-1].length != j){
                    right += triangle[i-1][j];
                }
                if(j-1 >=0){
                    left += triangle[i-1][j-1];
                }
                triangle[i][j] = Math.max(left,right);
            }
        }
        for(int i = 0;i<triangle[depth-1].length;i++){
            max = Math.max(max, triangle[depth-1][i]);
        }
        return max;
    }
}