import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int total = 0;

        for(int i=0;i<5;i++){
            total +=  (int)Math.pow(Integer.parseInt(st.nextToken()),2);    
        }
        bw.write((total%10)+"");
        bw.flush();

        
    }
}
