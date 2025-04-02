import java.io.*;
import java.util.*;

class Node{
    int i,j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
    
}

public class Solution {
    static int N;
    static int M;
    static int R;
    static int C;
    static int L;
    static int[][] matrix;
    static int cnt;
    static int[][] di = {{0},
                         {-1,1,0,0},
                         {-1,1},
                         {0,0},
                         {-1,0},
                         {1,0},
                         {1,0},
                         {-1,0}
                        };
    static int[][] dj = {{0},
                         {0,0,-1,1},
                         {0,0},
                         {-1,1},
                         {0,1},
                         {0,1},
                         {0,-1},
                         {0,-1}
                        };
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            bw.write("#"+t+" ");
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            matrix = new int[N][M];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            BFS();
            
            bw.write(cnt+"\n");
        }
        bw.close();
    }
    public static void BFS(){
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new Node(R,C));
        cnt = 1;
        L--;
        visited[R][C] = true;
        int prevQSize = 1;

        while(!q.isEmpty() && L != 0){
            while(prevQSize != 0){
                Node cur = q.poll();
                int opt = matrix[cur.i][cur.j];

                for(int k=0;k<di[opt].length;k++){
                    int newi = cur.i + di[opt][k];
                    int newj = cur.j + dj[opt][k];
                    if(newi<0 || newi>=N || newj<0 || newj>=M) continue;
                    if(matrix[newi][newj] == 0 || visited[newi][newj]) continue;
                    int nextopt = matrix[newi][newj];
                    int flag = 0;
                    for(int idx = 0;idx<di[nextopt].length;idx++){
                        int nexti = newi + di[nextopt][idx];
                        int nextj = newj + dj[nextopt][idx];
                        if(nexti == cur.i && nextj == cur.j) flag = 1;
                    }
                    if(flag == 0) continue;
                    q.add(new Node(newi,newj));
                    visited[newi][newj] = true;
                    cnt++;
                }
                prevQSize--;
            }
            prevQSize = q.size();
            L--;
        }
    }
}
