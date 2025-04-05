import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int total = 0;
        int current = 0;
        String[] minusSplit = br.readLine().split("-");

        for(int idx = 0;idx<minusSplit.length;idx++){
            String[] plusSplit = minusSplit[idx].split("\\+");
            current = 0;
            for(String plus: plusSplit){
                current += Integer.parseInt(plus);
            }

            if(idx == 0){
                total = current;
            }else{
                total -= current;
            }
        }

        bw.write(total + "\n");
        bw.close();
    }

}
