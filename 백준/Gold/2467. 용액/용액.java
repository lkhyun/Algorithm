import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] minValues = new int[2];
        int min = Integer.MAX_VALUE;

        int i = 0;
        int j = N-1;
        while(i < j){
            if(Math.abs(arr[i] + arr[j]) < Math.abs(min)){
                min = Math.abs(arr[i] + arr[j]);
                minValues[0] = arr[i];
                minValues[1] = arr[j];
            }
            if(arr[i] + arr[j] < 0){ //음수일때 왼쪽거 오른쪽으로
                i++;
            }else if(arr[i] + arr[j] > 0){ //양수일때 오른쪽거 왼쪽으로
                j--;
            }else{
                minValues[0] = arr[i];
                minValues[1] = arr[j];
                break;
            }
        }
        bw.write(minValues[0] + " " + minValues[1]);
        bw.flush();
        bw.close();
    }
}
