import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Character.getNumericValue(str[j]);
            }
        }
        bw.write(BFS()+"");
        bw.close();
    }
    public static int BFS(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
        q.offer(new int[]{0,0,1,0}); // i,j,cnt
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        int min = -1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == N-1 && cur[1] == M-1 && cur[3] <= 1){
                if(min == -1){
                    min = cur[2];
                }else{
                    min = Math.min(min,cur[2]);
                }
            }

            for (int k = 0; k < 4; k++) {
                int newi = cur[0] + di[k];
                int newj = cur[1] + dj[k];
                if(newi < 0 || newi >= N || newj < 0 || newj >= M){
                    continue;
                }
                if(matrix[newi][newj] == 1){ // 벽을 만남
                    if(cur[3] == 0){ //한번도 안 뚫은 애가 왔을 경우
                        if(!visited[newi][newj][0]){ // 안 뚫은 애가 먼저 오지만 않았으면 됨.
                            q.offer(new int[]{newi,newj,cur[2]+1, cur[3]+1});
                            visited[newi][newj][0] = true; //안 뚫은 애 왔다감
                        }
                    }
                    //else 뚫은 애는 어차피 1번밖에 못뚫으니까 여기 와도 할게 없음
                }else{ // 벽이 아님
                    if(cur[3] == 0){//한번도 안뚫은 애가 옴
                        if(!visited[newi][newj][0]){
                            q.offer(new int[]{newi,newj,cur[2]+1, cur[3]});
                            visited[newi][newj][0] = true;
                        }
                    }else{//한번 뚫은 애가 옴
                        if(!visited[newi][newj][0] && !visited[newi][newj][1]){
                            //뚫는 이유가 빨리 올라고 하는건데 안 뚫은 애보다 느리면 차피 의미 없음.
                            //뚫었든 안뚫었든 누가 먼저 왔다면 못감.
                            q.offer(new int[]{newi,newj,cur[2]+1, cur[3]});
                            visited[newi][newj][1] = true;
                        }
                    }
                }
            }
        }
        return min;
    }
}


