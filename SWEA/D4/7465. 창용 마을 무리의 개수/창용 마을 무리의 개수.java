import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static int M;
    static int[] parents;
    static void make(){
        parents = new int[N+1];
        for(int i=0;i<N;i++){
            parents[i] = i; // 자신의 부모는 자신
        }
    }
    static int find(int a){
        if(a == parents[a]) return a;
        else return parents[a] = find(parents[a]); //경로 압축
    }
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot){
            return false;
        }else{
            if(aRoot<bRoot){
                parents[bRoot] = aRoot;
            }else{
                parents[aRoot] = bRoot;
            }
            return true;
        }
    }
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            make();

            bw.write("#"+t+" ");

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            Set<Integer> s = new HashSet<>();
            for(int i=1;i<=N;i++){
                s.add(find(i));
            }
            bw.write(s.size() + "\n");
        }
        bw.close();
    }
}
