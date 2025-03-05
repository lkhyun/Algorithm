import java.io.*;
import java.util.*;

public class Solution {
    static int H;
    static int W;
    static char[][] map;
    static int cari;
    static int carj;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static char[] shape = {'^','v','<','>'};
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            for(int i=0;i<H;i++){
                char[] str = br.readLine().toCharArray();
                for(int j=0;j<W;j++){
                    if(str[j] == '<' || str[j] == '>' || str[j] == 'v' || str[j] == '^'){
                        cari = i;
                        carj = j;
                    }
                    map[i][j] = str[j];
                }
            }
            int N = Integer.parseInt(br.readLine());
            char[] cmd = br.readLine().toCharArray();

            for(char c : cmd){
                if(c=='U'){shift(0);}
                else if(c=='D'){shift(1);}
                else if(c=='L'){shift(2);}
                else if(c=='R'){shift(3);}
                else if(c=='S'){
                    if(map[cari][carj] == '^'){shoot(0);}
                    else if(map[cari][carj] == 'v'){shoot(1);}
                    else if(map[cari][carj] == '<'){shoot(2);}
                    else if(map[cari][carj] == '>'){shoot(3);}
                }
            }

            bw.write("#"+t+" ");
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
        }
        bw.close();
    }
    
    public static void shift(int order) {
        int newi = cari + di[order];
        int newj = carj + dj[order];
        if (newi >= 0 && newi < H && newj >= 0 && newj < W && map[newi][newj] == '.') {
            map[newi][newj] = shape[order];
            map[cari][carj] = '.';
            cari = newi;
            carj = newj;
        }else{
            map[cari][carj] = shape[order];
        }
    }
    public static void shoot(int order){
        int newi = cari + di[order];
        int newj = carj + dj[order];
        while(newi >= 0 && newi < H && newj >= 0 && newj < W && map[newi][newj]!='#'){
            if(map[newi][newj]=='*'){
                map[newi][newj] = '.';
                break;
            }
            newi += di[order];
            newj += dj[order];
        }
    }
}
