import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = N;
        for(int i=0;i<N;i++){
            int current = Integer.parseInt(st.nextToken());
            if(current == 1){
                count--;
                continue;
            }
            if(current == 2){
                continue;
            }
            for(int j=2;j<=Math.sqrt(current);j++){
                if(current%j==0){
                    count--;
                    break;
                }
            }
        }
        bw.write(count+"");
        bw.flush();
    }
}
