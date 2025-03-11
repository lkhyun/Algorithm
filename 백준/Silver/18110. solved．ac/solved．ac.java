import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 0){
            System.out.println("0");
            return;
        }
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        double temp = N*0.15; 
        int cutoff = (temp<(double)((int)temp + 0.5)) ? (int)temp : (int)temp+1;

        double total = 0;
        for(int i=cutoff;i<N-cutoff;i++){
            total += arr[i];
        }
        total = total/(N-cutoff*2);
        int result = (total<(double)((int)total + 0.5)) ? (int)total : (int)total+1;
        System.out.println(result);
    }
}
