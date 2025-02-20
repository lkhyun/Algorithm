import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[] number;
    static List<Integer> l;
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("input.txt"));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        number = new int[N];
        l = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            number[i] = i+1;
        }
        search(0,0);
        bw.flush();
    }
    public static void search(int depth,int start) throws Exception{
        if(depth == M){
            for(int i:l){
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=start;i<N;i++){
            l.add(number[i]);
            search(depth+1,i+1);
            l.remove(l.size()-1);
        }
    }
    
}