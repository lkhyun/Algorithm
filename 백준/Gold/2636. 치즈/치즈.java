import java.util.*;
import java.io.*;

class Node{
    int x;
    int y;
    Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class Main
{
    static int H;
    static int W;
    static boolean[][] cheeze;
    static List<Node> melt = new LinkedList<>();
    static boolean flag = false;
    static int cnt = 0;
    static int time = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        cheeze = new boolean[H+2][W+2]; // padding:1

        for(int i=1;i<=H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=W;j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    flag = true;// 치즈가 있는지
                    cnt++;
                    cheeze[i][j] = true;
                }
            }
        }
        int result = 0;
        if(flag){
            result = BFS();
        }
        
        bw.write(time+"\n"+result);
        bw.close();
    }
    public static int BFS(){
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        while(flag){
            time++;
            int currentcnt = 0;
            flag = false;
            ArrayDeque<Node> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[H+2][W+2];
            for(int i=1;i<=H;i++){
                for(int j=1;j<W;j++){
                    visited[i][j] = cheeze[i][j];
                }
            }
            q.add(new Node(0,0));
            visited[0][0] = true;
            while(!q.isEmpty()){
                Node cur = q.poll();
                for(int k = 0;k<4;k++){
                    int newx = cur.x + dx[k];
                    int newy = cur.y + dy[k];
                    if(newx>=0&&newx<W+2&&newy>=0&&newy<H+2){
                        if(!cheeze[newy][newx]){
                            if(!visited[newy][newx]){
                                q.add(new Node(newx,newy));
                                visited[newy][newx] = true;
                            }
                        }else{
                            melt.add(new Node(newx,newy));
                        }
                    }
                }
            }
            
            for(Node n : melt){
                if(cheeze[n.y][n.x]){
                    cheeze[n.y][n.x] = false;
                    currentcnt++;
                }
            }
            cnt -= currentcnt;
            if(cnt>0) flag = true;
            else{
                return currentcnt;
            }
        }
        return 0;
    }
}