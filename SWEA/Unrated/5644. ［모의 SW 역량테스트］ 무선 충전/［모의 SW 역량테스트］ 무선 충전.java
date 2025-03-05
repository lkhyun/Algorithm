import java.io.*;
import java.util.*;
class MapInfo{
    List<Integer> BC;
    MapInfo(int num){
        BC = new LinkedList<>();
        BC.add(num);
    }
}
public class Solution {
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            MapInfo[][] map = new MapInfo[11][11]; // 1부터
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int[] BC = new int[A+1];

            int[] moveA = new int[M+1]; //1부터 A의 이동 경로
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=M;i++){
                moveA[i]=Integer.parseInt(st.nextToken());
            }
            int[] moveB = new int[M+1]; //B의 이동 경로
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=M;i++){
                moveB[i]=Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=A;i++){ //map에 BC의 영향을 모두 표시하기
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int ci = Integer.parseInt(st.nextToken());
                int pi = Integer.parseInt(st.nextToken());
                BC[i] = pi; //BC 세기 정보
                for(int j = -ci;j<=ci;j++){
                    int diff = ci - Math.abs(j);
                    for(int k=-diff;k<=diff;k++){
                        int newy = y+j;
                        int newx = x+k;
                        if(newy>=1&&newy<=10&&newx>=1&&newx<=10){
                            if(map[newy][newx]==null){
                                map[newy][newx] = new MapInfo(i);
                            }else{
                                if(map[newy][newx].BC.contains(i)) continue;
                                map[newy][newx].BC.add(i);
                            }
                        }
                    }
                }
            }
            int total = 0;
            int Ax = 1;
            int Ay = 1;
            int Bx = 10;
            int By = 10;
            int[] dy = {0,-1,0,1,0};
            int[] dx = {0,0,1,0,-1};
            for(int i=0;i<=M;i++){
                int max = 0;
                Ax = Ax + dx[moveA[i]];
                Ay = Ay + dy[moveA[i]];
                Bx = Bx + dx[moveB[i]];
                By = By + dy[moveB[i]];
                MapInfo tempA = map[Ay][Ax];
                MapInfo tempB = map[By][Bx];
                int currentvalue = 0;
                if(tempA != null && tempB != null){
                    for(int a:tempA.BC){
                        for(int b:tempB.BC){
                            if(a==b){
                                currentvalue = BC[a];
                            }else{
                                currentvalue = BC[a] + BC[b];
                            }
                            max = Math.max(max,currentvalue);
                        }
                    }
                }else if(tempA != null){
                    for(int a:tempA.BC){
                        max = Math.max(max,BC[a]);
                    }
                }else if(tempB != null){
                    for(int b:tempB.BC){
                        max = Math.max(max,BC[b]);
                    }
                }
                total += max;
            }

            bw.write("#"+t+" "+total+"\n");
        }
        bw.close();
    }
}
