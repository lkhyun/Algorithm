import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,String> m = new HashMap<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            m.put(st.nextToken(),st.nextToken());
        }
        for(int i=0;i<M;i++){
            bw.write(m.get(br.readLine())+"\n");
        }
        bw.close();
    }
}
