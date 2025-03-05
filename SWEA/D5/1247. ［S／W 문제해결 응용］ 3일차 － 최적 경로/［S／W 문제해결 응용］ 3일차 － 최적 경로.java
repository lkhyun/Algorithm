import java.io.*;
import java.util.*;
class Node{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    static int N;
    static Node[] point;
    static int[][] graph;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            point = new Node[N+2];//0은 회사, N+1은 집
            graph = new int[N+2][N+2];
            visited = new boolean[N+1];
            min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int companyX = Integer.parseInt(st.nextToken());
            int companyY = Integer.parseInt(st.nextToken());
            point[0] = new Node(companyX,companyY);
            int houseX = Integer.parseInt(st.nextToken());
            int houseY = Integer.parseInt(st.nextToken());
            point[N+1] = new Node(houseX, houseY);
            for(int i=1;i<=N;i++){
                int tempX = Integer.parseInt(st.nextToken());
                int tempY = Integer.parseInt(st.nextToken());
                point[i] = new Node(tempX, tempY);
            }

            for(int i=0;i<N+2;i++){
                for(int j=0;j<N+2;j++){
                    if(i==j){
                        graph[i][j] = 0;
                    }else if((i==0 && j==N+1) || (i==N+1 && j==0)){
                        graph[i][j] = Integer.MAX_VALUE;
                    }else{
                        graph[i][j] = Math.abs(point[i].x - point[j].x) + Math.abs(point[i].y - point[j].y);
                    }
                }
            }
            find(0,0,0);
            bw.write("#"+t+" "+min+"\n");
        }
        bw.close();
    }
    public static void find(int cur,int sum,int cnt){
        if(sum >= min) return;
        if(cnt == N){
            min = Math.min(min,sum+graph[cur][N+1]);
        }
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i] = true;
                find(i,sum+graph[cur][i],cnt+1);
                visited[i] = false;
            }
        }
    }
}
