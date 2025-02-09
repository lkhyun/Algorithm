import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] words = br.readLine().toCharArray();
        int[] counts = new int[26];
        Arrays.fill(counts,-1);
        for(int i=0;i<words.length;i++){
            if(counts[words[i]-'a'] == -1) {
                counts[words[i] - 'a'] = i;
            }
        }
        for(int i=0;i<26;i++){
            bw.write(counts[i] +" ");
        }
        bw.flush();
    }
}