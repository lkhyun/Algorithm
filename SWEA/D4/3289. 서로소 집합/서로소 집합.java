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
                int cmd = Integer.parseInt(st.nextToken());

                if (cmd == 0) {// 합집합 연산
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    union(a, b);
                } else if (cmd == 1) {// 집합 포함 여부
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if (find(a) == find(b))
                        bw.write("1");
                    else
                        bw.write("0");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }
}
