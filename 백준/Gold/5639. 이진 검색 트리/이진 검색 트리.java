
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int cnt = 0;
    static int[] arr = new int[10000];

    public static void main(String[] args) throws IOException{
        String str;
        while((str = br.readLine()) != null && !str.isEmpty()){
            arr[cnt++] = Integer.parseInt(str);
        }
        search(0,cnt-1);
        bw.close();
    }
    public static void search(int start, int end) throws IOException{
        if(start > end) return;
        if(start == end){
            bw.write(arr[start]+"\n");
            return;
        }
        int i;
        for (i = start+1; i <= end; i++) {
            if(arr[start]<arr[i]){
                break;
            }
        }
        search(start+1,i-1);
        search(i,end);
        bw.write(arr[start]+"\n");
    }
}