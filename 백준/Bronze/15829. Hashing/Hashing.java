import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int L = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        int r = 31;
        int M = 1234567891;
        long hash = 0;
        long power = 1;
        for(int i=0;i<L;i++){
            int alphabet= (str[i]-'a')+1;
            hash += (alphabet*power)%M;
            hash %=M;
            power = (power*r)%M;
        }

        bw.write(hash+"");
        bw.flush();
    }
}
