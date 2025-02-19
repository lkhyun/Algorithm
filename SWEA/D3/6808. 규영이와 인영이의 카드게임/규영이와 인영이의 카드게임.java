import java.util.*;
import java.io.*;

public class Solution {
    static int[] gyu = new int[9];
    static int[] in = new int[9];
    static boolean[] visited = new boolean[19];
    static int win = 0;
    static int lose = 0;
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("s_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1;t<=T;t++){ 
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<9;i++){
                gyu[i] = Integer.parseInt(st.nextToken());
                visited[gyu[i]] = true;
            }
            back(0);
            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose);
            System.out.println(sb.toString());
            win = 0;
            lose = 0;
            Arrays.fill(visited,false);
        }
    }
    public static void back(int depth){
        if(depth == 9){
            int gyutotal = 0;
            int intotal = 0;
            for(int i=0;i<9;i++){
                if(gyu[i] < in[i]){ //규영 패배
                    intotal += gyu[i]+in[i];
                }else{ //규영 승리
                    gyutotal += gyu[i]+in[i];
                }
            }
            if(gyutotal>intotal){win++;}
            else{lose++;}
        }

        for(int i=1;i<=18;i++){
            if(!visited[i]){
                visited[i] = true;
                in[depth] = i;
                back(depth+1);
                visited[i] = false;
            }
        }
    }
}
