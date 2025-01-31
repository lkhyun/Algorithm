import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static BufferedReader br;
    static BufferedWriter bw;
    static List<Integer> s;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        s = new LinkedList<>();
        backtracking(0);
    }
    static void backtracking(int depth) throws Exception{
        if(depth == M){
            for(int a : s){
                bw.write(a+" ");
            }
            bw.write("\n");
            bw.flush();
            s.remove(s.get(s.size()-1));
            return;
        }
        for(int i=1;i<=N;i++){
            if(s.contains(i)){continue;}
            s.add(i);
            backtracking(depth+1);
        }
        if(depth!=0){s.remove(s.get(s.size()-1));}
    }
}
