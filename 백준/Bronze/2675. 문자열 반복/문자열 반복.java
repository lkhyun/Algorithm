import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int R = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for(int i=0;i<str.length();i++){
                sb.append(String.valueOf(str.charAt(i)).repeat(R));
            }
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
    }
}
