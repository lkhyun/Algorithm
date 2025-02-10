import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 0;
        int i=666;
        int N = Integer.parseInt(br.readLine());
        String str = "666";
        while(true){
            if(str.contains("666")){
                count++;
                if(count==N){break;}
            } 
            str = String.valueOf(++i);
        }
        bw.write(str);
        bw.flush();
    }
    
}
