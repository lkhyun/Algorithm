
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static char[][] box;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        box = new char[N][N*2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N*2; j++) {
                box[i][j] = ' ';
            }
        }

        recursive(0,(N*2-1)/2,N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N*2 - 1; j++) {
                bw.write(box[i][j]+"");
            }
            bw.write("\n");
        }
        bw.close();
    }
    public static void print(int starti, int startj){
        box[starti][startj] = '*';
        box[starti+1][startj-1] = '*';
        box[starti+1][startj+1] = '*';
        for (int i = -2; i < 3; i++) {
            box[starti+2][startj+i] = '*';
        }
    }
    public static void recursive(int starti, int startj, int size){
        if(size == 3){
            print(starti,startj);
            return;
        }
        recursive(starti,startj,size/2);
        recursive(starti+(size/2),startj-(size/2),size/2);
        recursive(starti+(size/2),startj+(size/2),size/2);

    }
}