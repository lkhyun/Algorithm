import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer> kinds;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            Map<String,Integer> clothes = new HashMap<>();
            cnt = 1;
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();
                clothes.put(kind,clothes.getOrDefault(kind,0)+1);
            }
            kinds = new ArrayList<>(clothes.values());
            for(int i=0;i<kinds.size();i++){
                cnt *= (kinds.get(i)+1);
            }
            bw.write(cnt-1+"\n");
        }
        bw.close();
    }
    
}
// 옷 3개, 바지 4개, 목도리 2개