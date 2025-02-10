import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int L = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        int hash = 0;

        for(int i=0;i<L;i++){
            int alphabet= (str[i]-'a')+1;
            hash += alphabet*(int)Math.pow(31,i);
        }
        
        bw.write(hash+"");
        bw.flush();
    }
}
