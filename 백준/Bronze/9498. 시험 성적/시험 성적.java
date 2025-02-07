import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken());
        if(N>=90 && N<=100){
            bw.write("A");
        }else if (N>=80 && N<90){
            bw.write("B");
        }else if(N>=70 && N<80){
            bw.write("C");
        }else if(N>=60 && N<70){
            bw.write("D");
        }else{
            bw.write("F");
        }
        bw.flush();
    }
}
