import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            int N = Integer.parseInt(br.readLine());
            int count = 1;
            int visit = 0;
            int temp = 0;
            while(visit != (1<<10)-1){
                temp = N*count++;
                String[] str = String.valueOf(temp).split("");
                for(String s: str){
                    visit |= 1<<Integer.parseInt(s);
                }
            }
            bw.write("#"+t+" "+temp+"\n");
            bw.flush();
        }
    }
}
