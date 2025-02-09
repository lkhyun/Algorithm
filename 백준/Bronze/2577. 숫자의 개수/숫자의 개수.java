import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        String str = String.valueOf(A*B*C);
        for(int i=0;i<str.length();i++){
            int index = Character.getNumericValue(str.charAt(i));
            arr[index]++;
        }
        for(int i : arr){
            bw.write(i+"\n");
        }
        bw.flush();
    }
}
