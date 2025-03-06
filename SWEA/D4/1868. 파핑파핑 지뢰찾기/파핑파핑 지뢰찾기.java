import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t<T;t++){
            int N = sc.nextInt();
            int matrix[][] = new int[N][N];
            sc.nextLine();
            for(int i = 0; i<N;i++){ //입력 저장
                char input[] = sc.nextLine().toCharArray();
                for(int j = 0; j<N;j++){
                    if (input[j] == '*'){
                        matrix[i][j] = 9; //최대 지뢰 개수는 8개이므로 9를 실제 지뢰로 사용
                        adjacentProcess(matrix,i,j,1);
                    }
                }
            }
 
            int clickcount = 0;
            for(int i = 0; i<N;i++){
                for(int j = 0; j<N;j++){
                    if (matrix[i][j] == 0){
                        clickcount += 1;
                        matrix[i][j] = 10; // 연쇄 반응
                        adjacentProcess(matrix,i,j,2);
                    }
                }
            }
            for(int i = 0; i<N;i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] < 9) {
                        clickcount += 1;
                    }
                }
            }
            System.out.printf("#%d %d\n",t+1,clickcount);
        }
    }
    public static void adjacentProcess(int[][] matrix,int i, int j, int flag){
        int dx[] = {-1,0,1,1,1,0,-1,-1};
        int dy[] = {-1,-1,-1,0,1,1,1,0};
        for(int adjacent = 0; adjacent < 8; adjacent++){
            int row = i + dy[adjacent];
            int column = j + dx[adjacent];
            if(flag == 1){
                if (row>=0 && row<matrix.length && column>=0 && column< matrix.length && matrix[row][column]!=9){
                    matrix[row][column] += 1;
                }
            }
            else if(flag == 2){
                if (row>=0 && row<matrix.length && column>=0 && column< matrix.length){
                    if (matrix[row][column]==0){
                        matrix[row][column] = 10;
                        adjacentProcess(matrix,row,column,2);
                    }
                    else{
                        matrix[row][column] = 10;
                    }
                }
            }
        }
    }
}