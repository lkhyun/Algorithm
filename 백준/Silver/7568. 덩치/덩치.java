import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        int[] height = new int[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            int temp = 1;
            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(weight[i]<weight[j]&&height[i]<height[j]){
                    temp++;
                }
            }
            bw.write(String.valueOf(temp)+" ");
        }
        bw.flush();
    }
}
