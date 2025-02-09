import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        int max = temp;
        int min = temp;
        for(int n = 1; n<N;n++){
            temp = Integer.parseInt(st.nextToken());
            min = Math.min(min,temp);
            max = Math.max(max,temp);
        }
        bw.write(min +" " + max);
        bw.flush();
    }
}
