import java.io.*;
import java.util.*;

public class Main {
    static class state{
        int[] red;
        int[] blue;
        int moveCnt;
        state(int redi, int redj, int bluei, int bluej, int moveCnt){
            this.red = new int[]{redi,redj};
            this.blue = new int[]{bluei,bluej};
            this.moveCnt = moveCnt;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static char[][] board;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int[] red = new int[2];
    static int[] blue = new int[2];
    static int[] out = new int[2];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'O'){
                    out[0] = i;
                    out[1] = j;
                }else if(board[i][j] == 'B'){
                    blue[0] = i;
                    blue[1] = j;
                }else if(board[i][j] == 'R'){
                    red[0] = i;
                    red[1] = j;
                }
            }
        }
        bw.write(BFS() + "");
        bw.close();
    }

    static int[] moveMarble(int i, int j, int dir) {
        int ni = i;
        int nj = j;
        int moveCnt = 0;
        int reachedHole = 0;

        while(true) {
            ni += di[dir];
            nj += dj[dir];
            moveCnt++;

            if(ni < 0 || ni >= N || nj < 0 || nj >= M || board[ni][nj] == '#') {
                ni -= di[dir];
                nj -= dj[dir];
                moveCnt--;
                break;
            }

            if(board[ni][nj] == 'O') {
                reachedHole = 1;
                break;
            }
        }

        return new int[]{ni, nj, moveCnt, reachedHole};
    }

    static int BFS(){
        int answer = -1;
        ArrayDeque<state> q = new ArrayDeque<>();
        q.add(new state(red[0],red[1],blue[0],blue[1],0));
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;

        loop: while(!q.isEmpty()){
            state cur = q.poll();
            if(cur.moveCnt >= 10) continue;

            for (int k = 0; k < 4; k++) {
                boolean redOut = false;
                boolean blueOut = false;

                int[] redResult = moveMarble(cur.red[0], cur.red[1], k);
                int[] blueResult = moveMarble(cur.blue[0], cur.blue[1], k);

                int ri = redResult[0];
                int rj = redResult[1];
                int redMoveCnt = redResult[2];
                boolean redReachedHole = redResult[3] == 1;

                int bi = blueResult[0];
                int bj = blueResult[1];
                int blueMoveCnt = blueResult[2];
                boolean blueReachedHole = blueResult[3] == 1;
                
                if(redReachedHole) redOut = true;
                if(blueReachedHole) blueOut = true;
                
                if(blueOut) continue;
                
                if(redOut) {
                    answer = cur.moveCnt + 1;
                    break loop;
                }
                
                //충돌처리
                if(ri == bi && rj == bj) {
                    if(redMoveCnt > blueMoveCnt) {
                        ri -= di[k];
                        rj -= dj[k];
                    } else {
                        bi -= di[k];
                        bj -= dj[k];
                    }
                }

                if(!visited[ri][rj][bi][bj]){
                    q.add(new state(ri,rj,bi,bj,cur.moveCnt+1));
                    visited[ri][rj][bi][bj] = true;
                }
            }
        }
        return answer;
    }
}