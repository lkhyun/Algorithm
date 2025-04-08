import java.io.*;
import java.util.*;

public class Solution {
    static int N; 
    static int[] arr;
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            bw.write("#"+t+" ");
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] LIS = new int[N];

            for(int i=0;i<N;i++){
                LIS[i] = 1;
                for(int j=i-1;j>=0;j--){
                    if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1){
                        LIS[i] = LIS[j] + 1;
                    }
                }
            }

            int max = 0;

            for(int i=0;i<N;i++){
                max = Math.max(max,LIS[i]);
            }

            bw.write(max+"\n");
        }
        bw.close();
    }

}
