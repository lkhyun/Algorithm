import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(N==1){
            if(arr[0]%9 == 0){
                bw.write(arr[0]/9 + "");
            }else{
                bw.write(arr[0]/9 + 1 + "");
            }
        }else if(N==2){
            int cnt = 0;
            while(arr[0]>0 || arr[1]>0){
                if(arr[0]>arr[1]){
                    arr[0] -= 9;
                    arr[1] -= 3;
                }else{
                    arr[1] -= 9;
                    arr[0] -= 3;
                }
                cnt++;
            }
            bw.write(cnt + "");
        }else{
            bw.write(BFS(arr) + "");
        }
        bw.close();
    }
    public static int BFS(int[] arr){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[61][61][61];
        q.offer(new int[]{arr[0], arr[1], arr[2],0});
        visited[arr[0]][arr[1]][arr[2]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0]==0 && cur[1]==0 && cur[2]==0){
                return cur[3];
            }
            int a,b,c;
            a = Math.max(cur[0] - 9, 0);
            b = Math.max(cur[1] - 3, 0);
            c = Math.max(cur[2] - 1, 0);
            if(!visited[a][b][c]){
                q.offer(new int[]{a,b,c, cur[3]+1});
                visited[a][b][c] = true;
            }
            a = Math.max(cur[0] - 9, 0);
            b = Math.max(cur[1] - 1, 0);
            c = Math.max(cur[2] - 3, 0);
            if(!visited[a][b][c]){
                q.offer(new int[]{a,b,c, cur[3]+1});
                visited[a][b][c] = true;
            }
            a = Math.max(cur[0] - 3, 0);
            b = Math.max(cur[1] - 1, 0);
            c = Math.max(cur[2] - 9, 0);
            if(!visited[a][b][c]){
                q.offer(new int[]{a,b,c, cur[3]+1});
                visited[a][b][c] = true;
            }
            a = Math.max(cur[0] - 3, 0);
            b = Math.max(cur[1] - 9, 0);
            c = Math.max(cur[2] - 1, 0);
            if(!visited[a][b][c]){
                q.offer(new int[]{a,b,c, cur[3]+1});
                visited[a][b][c] = true;
            }
            a = Math.max(cur[0] - 1, 0);
            b = Math.max(cur[1] - 9, 0);
            c = Math.max(cur[2] - 3, 0);
            if(!visited[a][b][c]){
                q.offer(new int[]{a,b,c, cur[3]+1});
                visited[a][b][c] = true;
            }
            a = Math.max(cur[0] - 1, 0);
            b = Math.max(cur[1] - 3, 0);
            c = Math.max(cur[2] - 9, 0);
            if(!visited[a][b][c]) {
                q.offer(new int[]{a, b, c, cur[3] + 1});
                visited[a][b][c] = true;
            }
        }
        return 0;
    }
}

