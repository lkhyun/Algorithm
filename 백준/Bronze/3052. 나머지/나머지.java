import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<10;i++){
            int cur = Integer.parseInt(br.readLine());
            s.add(cur%42);
        }
        bw.write(s.size()+"");
        bw.flush();
    }
}
