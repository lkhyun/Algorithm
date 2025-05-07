
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static boolean[] col;
    static boolean[] diagonal1;
    static boolean[] diagonal2;
    static int count = 0;


    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        col = new boolean[N];
        diagonal1 = new boolean[N*2];
        diagonal2 = new boolean[N*2];
        search(0);
        bw.write(count+"");
        bw.close();
    }
    public static void search(int row){
        if(row == N){
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(col[i] || diagonal1[row+i] || diagonal2[row-i+N-1]) continue;
            col[i] = true;
            diagonal1[row+i] = true;
            diagonal2[row-i+N-1] = true;
            search(row+1);
            col[i] = false;
            diagonal1[row+i] = false;
            diagonal2[row-i+N-1] = false;
        }
    }
}