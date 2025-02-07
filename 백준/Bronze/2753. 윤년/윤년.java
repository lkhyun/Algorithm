import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken());
        if(N%4==0 && (N%100!=0 || N%400==0)){
            bw.write("1");
        }else{
            bw.write("0");
        }
        bw.flush();
    }
}
