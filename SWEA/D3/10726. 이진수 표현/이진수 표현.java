import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int shiftN = (1<<N)-1;
            int isOn = M & shiftN;
            if(isOn == shiftN){
                bw.write("#"+t+" ON\n");
            }
            else{
                bw.write("#"+t+" OFF\n");
            }
            bw.flush();
        }
    }
}
