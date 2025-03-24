import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        permutation(1,0);
        bw.close();
    }
    public static void permutation(int cur, int depth) throws Exception{
        if(depth == M){
            for(int i = 1;i<=M;i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        } 
        for(int i=cur;i<=N;i++){
            arr[depth+1] = i;
            permutation(i,depth+1);
        }
    }
}