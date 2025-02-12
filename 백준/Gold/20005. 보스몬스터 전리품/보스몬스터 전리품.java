import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
    int i;
    int j;
    int dist;
    Node(int i, int j, int dist){
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node o){
        return Integer.compare(this.dist,o.dist);
    }
}
public class Main {
    static int M;
    static int N;
    static int[][] map;
    static List<Node> players = new ArrayList<>(); //플레이어 위치 key:i value:j
    static Map<Integer,Integer> damage = new HashMap<>(); //플레이어의 데미지 key:플레이어 숫자 value: 데미지
    static List<Node> arriveTime; //도착 시간
    static int bossHealth;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        arriveTime = new ArrayList<>(P);
        for(int i=0;i<M;i++){
            char[] str = br.readLine().toCharArray();
            for(int j=0;j<N;j++){
                if(str[j] == '.'){map[i][j] = 0;}
                else if(str[j] == 'X'){map[i][j] = -1;}
                else if(str[j] == 'B'){map[i][j] = 27;}
                else{
                    map[i][j] = str[j]-'a'+1;
                    players.add(new Node(i,j,0));
                }
            }
        }
        for(int i=0;i<P;i++){
            st = new StringTokenizer(br.readLine());
            int player = st.nextToken().charAt(0)-'a'+1;
            damage.put(player,Integer.parseInt(st.nextToken()));
        }
        bossHealth = Integer.parseInt(br.readLine());

        //각 플레이어마다 BFS
        for(Node n:players){
            BFS(n.i,n.j);
        }
        Collections.sort(arriveTime);

        int prevTime = 0;
        int curTime = 0;
        int adder = 0;
        int hitPlayers = 0;
        for(int i=0;i<arriveTime.size();i++){
            Node n = arriveTime.get(i);
            if(i==0){ //처음 도착했을때
                curTime = n.dist;
                prevTime = n.dist;
                adder = damage.get(map[n.i][n.j]);
                hitPlayers++;
                continue;
            }
            if(prevTime == n.dist)//이전 플레이어와 동일한 시간대에 도착했을때
            {
                adder += damage.get(map[n.i][n.j]);
                hitPlayers++;
                continue;
            }
            else{
                prevTime = curTime;
                curTime = n.dist;
                bossHealth-=adder*(curTime-prevTime);
                adder += damage.get(map[n.i][n.j]);
                
                if(bossHealth>0){
                    hitPlayers++;
                }else{
                    break;
                }
            }
        }
        bw.write(hitPlayers+"");
        bw.flush();
    }
    static void BFS(int i,int j){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        q.offer(new Node(i,j,0));
        visited[i][j] = true;
        
        int[] di = {-1,1,0,0};
        int[] dj = {0,0,-1,1};
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(map[cur.i][cur.j] == 27){
                arriveTime.add(new Node(i,j,cur.dist));
                break;
            }
            for(int k=0;k<4;k++){
                int newi = cur.i + di[k];
                int newj = cur.j + dj[k];
                if(newi>=0 && newi<M && newj>=0 && newj<N && !visited[newi][newj] && map[newi][newj] != -1){
                    q.offer(new Node(newi,newj,cur.dist+1));
                    visited[newi][newj] = true;
                }
            }
        }
    }
}
