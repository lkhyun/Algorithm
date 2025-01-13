/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static final int[] dy = {-1,1,0,0}; //상하좌우
    static final int[] dx = {0,0,-1,1}; //상하좌우
    static int minimum;
    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int startY;
    static int startX;
    static int endY;
    static int endX;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T ; t++){
            minimum = Integer.MAX_VALUE;
            N = sc.nextInt();
            matrix = new int[N][N];
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){ // 배열 입력
                for(int j = 0; j < N; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            startY = sc.nextInt();
            startX = sc.nextInt();
            endY = sc.nextInt();
            endX = sc.nextInt();
            dfs(startY,startX,0);
            System.out.printf("#%d ",t+1);
            if(minimum == Integer.MAX_VALUE){System.out.println(-1);}
            else{System.out.println(minimum);}
        }
    }
    public static void dfs(int y, int x, int currentTime){
        if(minimum <= currentTime){return;}
        if(y == endY && x == endX) {
            minimum = currentTime;
            return;
        }
        for(int i = 0; i < 4; i++){
            int newy = y + dy[i];
            int newx = x + dx[i];
            if(newx >= 0 && newx < N && newy >= 0 && newy < N && !visited[newy][newx]){
                if(matrix[newy][newx] == 0){
                    visited[newy][newx] = true;
                    dfs(newy,newx,currentTime+1);
                    visited[newy][newx] = false;
                }
                else if(matrix[newy][newx] == 2){
                    int extraTime = 3 - (currentTime%3);
                    visited[newy][newx] = true;
                    dfs(newy,newx,currentTime + extraTime);
                    visited[newy][newx] = false;
                }
            }
        }
    }
}