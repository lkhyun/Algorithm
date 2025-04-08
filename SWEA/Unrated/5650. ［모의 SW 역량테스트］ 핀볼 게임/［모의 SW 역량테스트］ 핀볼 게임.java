import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int starti, startj;
    static int max;
    static int[][] matrix;
    // 방향 벡터: 0=위, 1=아래, 2=왼, 3=오른
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    // 웜홀(6~10) -> [i1, j1, i2, j2] 형태로 저장
    static Map<Integer, List<Integer>> holes;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine().trim());
            matrix = new int[N][N];
            holes = new HashMap<>();
            max = 0;

            // 입력받기
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    // 웜홀(6~10) 위치 저장
                    if(matrix[i][j] >= 6 && matrix[i][j] <= 10){
                        List<Integer> temp = holes.getOrDefault(matrix[i][j], new ArrayList<>());
                        temp.add(i);
                        temp.add(j);
                        holes.put(matrix[i][j], temp);
                    }
                }
            }

            // 시작점은 "값이 0인 칸"에서만 4방향으로 출발
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(matrix[i][j] == 0){
                        starti = i;
                        startj = j;
                        // 4방향 시도
                        for(int d=0; d<4; d++){
                            play(i, j, d);
                        }
                    }
                }
            }

            bw.write("#" + t + " " + max + "\n");
        }
        bw.close();
    }

    // 공을 (curi, curj) 위치에서 direction 방향으로 출발시켜 점수 계산
    public static void play(int curi, int curj, int direction){
        int cnt = 0;
        boolean moved = false;  // "한 번이라도 움직였다"를 체크

        do {
            // 1) 빈 공간(0)을 만나면 그냥 직진
            while(matrix[curi][curj] == 0){
                // 시작점으로 복귀했으면 종료(단, 최소 1번은 움직인 뒤여야 함)
                if(curi == starti && curj == startj && moved) {
                    break;
                }
                moved = true;

                // 다음 위치
                int newi = curi + di[direction];
                int newj = curj + dj[direction];

                // 경계를 벗어나면 => 점수 +1, 방향 반전
                if(!inRange(newi, newj)){
                    cnt++;
                    direction = reverseDirection(direction);
                } else {
                    curi = newi;
                    curj = newj;
                }

                if(curi == starti && curj == startj && moved) {
                    break;
                }
                if(matrix[curi][curj] != 0) {
                    // 더 이상 while문을 돌지 않고 블록/웜홀/블랙홀 체크로 이동
                    break;
                }
            }

            // 2) 빈 공간 아닌 곳 => 블랙홀(-1)이거나 블록(1~5), 웜홀(6~10)
            if(curi == starti && curj == startj) {
                // 이미 시작점 도달했다면 break
                break;
            }
            if(matrix[curi][curj] == -1) {
                // 블랙홀 만났으면 게임 종료
                break;
            }
            // 블록(1~5)이라면 반사 + 점수 1 획득 후, 해당 칸에 머무른 뒤 다시 이동
            else if(matrix[curi][curj] >= 1 && matrix[curi][curj] <= 5){
                cnt++;
                direction = reflectBlock(matrix[curi][curj], direction);

                // 반사 후, 다음 위치로 이동 시도
                int newi = curi + di[direction];
                int newj = curj + dj[direction];
                // 경계 체크
                if(!inRange(newi, newj)){
                    cnt++;
                    direction = reverseDirection(direction);
                } else {
                    curi = newi;
                    curj = newj;
                }
            }
            // 웜홀(6~10)
            else if(matrix[curi][curj] >= 6 && matrix[curi][curj] <= 10){
                int hole = matrix[curi][curj];
                List<Integer> warp = holes.get(hole);

                // 같은 번호의 다른 웜홀 좌표로 이동
                if(warp.get(0) == curi && warp.get(1) == curj){
                    curi = warp.get(2);
                    curj = warp.get(3);
                } else {
                    curi = warp.get(0);
                    curj = warp.get(1);
                }
                // 웜홀 통과 뒤, 다시 다음 위치로 이동 시도
                int newi = curi + di[direction];
                int newj = curj + dj[direction];
                if(!inRange(newi, newj)){
                    cnt++;
                    direction = reverseDirection(direction);
                } else {
                    curi = newi;
                    curj = newj;
                }
            }

            if(curi == starti && curj == startj) {
                // 시작점 돌아오면 종료
                break;
            }
        } while(matrix[curi][curj] != -1);

        max = Math.max(max, cnt);
    }

    // 블록 번호(b: 1~5)에 따라 진입 방향(d: 0~3) -> 새 방향
    private static int reflectBlock(int b, int d){
        switch(b){
            case 1:
                // 0->1, 1->3, 2->0, 3->2
                if(d == 0) return 1;
                if(d == 1) return 3;
                if(d == 2) return 0;
                if(d == 3) return 2;
                break;
            case 2:
                // 0->3, 1->0, 2->1, 3->2
                if(d == 0) return 3;
                if(d == 1) return 0;
                if(d == 2) return 1;
                if(d == 3) return 2;
                break;
            case 3:
                // 0->2, 1->0, 2->3, 3->1
                if(d == 0) return 2;
                if(d == 1) return 0;
                if(d == 2) return 3;
                if(d == 3) return 1;
                break;
            case 4:
                // 0->1, 1->2, 2->3, 3->0
                if(d == 0) return 1;
                if(d == 1) return 2;
                if(d == 2) return 3;
                if(d == 3) return 0;
                break;
            case 5:
                // 모든 방향 180도 반사
                // (0->1, 1->0, 2->3, 3->2)
                if(d == 0) return 1;
                if(d == 1) return 0;
                if(d == 2) return 3;
                if(d == 3) return 2;
                break;
        }
        return d;  // 기본(실제로는 여기 도달 X)
    }

    // 경계에 부딪혔을 때 방향 반전
    private static int reverseDirection(int dir){
        // 0<->1, 2<->3
        if(dir == 0) return 1;
        if(dir == 1) return 0;
        if(dir == 2) return 3;
        if(dir == 3) return 2;
        return dir;
    }

    // 범위 체크
    private static boolean inRange(int r, int c){
        return (r >= 0 && r < N && c >= 0 && c < N);
    }
}
