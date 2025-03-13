import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,Boolean> noSee = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            noSee.put(str,true);
        }
        
        int total = 0;
        List<String> l = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            String str = br.readLine();
            if(noSee.getOrDefault(str,false)){
                total++;
                l.add(str);
            }
        }
        Collections.sort(l);
        bw.write(total+"\n");
        for(String str:l){
            bw.write(str+"\n");
        }
        bw.close();
    }
}
