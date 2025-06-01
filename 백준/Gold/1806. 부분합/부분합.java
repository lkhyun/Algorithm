import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] >= S){
                bw.write("1");
                bw.close();
                return;
            }
        }

        int i=0,j=1;
        int sum = arr[0]+arr[1];
        int minLen = 100000;
        while(j<N){
            if(sum<S){
                if(j==N-1){
                    break;
                }
                sum += arr[++j];
            }else {
                if(j-i+1 < minLen){
                    minLen = j-i+1;
                }
                sum -= arr[i++];
            }
        }

        if(minLen == 100000){
            bw.write("0");
        }else{
            bw.write(minLen+"");
        }
        bw.close();
    }
}
