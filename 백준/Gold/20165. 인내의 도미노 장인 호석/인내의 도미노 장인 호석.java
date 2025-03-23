import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N = 0; // 행 개수
    static int M = 0; // 열 개수
    static int R = 0; // 라운드 횟수
    static int[][] board; //게임판
    static boolean[][] state;
    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};
    static int answer = 0; // 총 쓰러트린 개수
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        state = new boolean[N+1][M+1];

        for(int i=1;i<=N;i++){ //배열 초기화
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<R;i++){ //라운드 반복
            /*공격*/
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            String D = st.nextToken();

            if(D.equals("E")){ //동
                answer += attack(X,Y,0);
            }else if(D.equals("W")){//서
                answer += attack(X,Y,1);
            }else if(D.equals("S")){//남
                answer += attack(X,Y,2);
            }else if(D.equals("N")){//북
                answer += attack(X,Y,3);
            }

            /*수비*/
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            state[X][Y] = false;
        }
        bw.write(answer+"\n");
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(state[i][j]){
                    bw.write("F ");
                }else{
                    bw.write("S ");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }
    public static int attack(int i, int j, int direction){
        int total = 0;
        if(!state[i][j]){
            state[i][j] = true;
            total++;
            for(int k=1;k<board[i][j];k++){
                int newi = i + di[direction]*k;
                int newj = j + dj[direction]*k;
                if(newi<=0 || newi>N || newj<=0 || newj>M) continue;
                total += attack(newi,newj,direction);
            }
        }
        return total;
    }
}
