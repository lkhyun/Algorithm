import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N,L;
    static Map<Integer,Integer> m = new TreeMap<>();
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            m.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1);
        }

        int cnt = 0;
        int cur = 0;
        for(int k : m.keySet()){
            if(cur < k-1){
                cur = k-1;
            }
            int end = m.get(k);
            while(cur < end){
                cur += L;
                cnt++;
            }
        }
        bw.write(cnt+"");
        bw.close();
    }
}