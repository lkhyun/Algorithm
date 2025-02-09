import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            String str = br.readLine();
            int count = 0;
            int total = 0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == 'O'){
                    count++;
                    total += count;
                }
                else{
                    count = 0;
                }
            }
            bw.write(total+"\n");
        }
        bw.flush();
    }
}
