import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[] number;
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        number = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            sum += number[i];
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(end-start+1 <= start-1+(N-end)){
                int temp = 0;
                for(int j=start-1;j<end;j++){
                    temp += number[j];
                }
                bw.write(temp+"\n");
            }else{
                int temp = sum;
                for(int j=0;j<start-1;j++){
                    temp -= number[j];
                }
                for(int j=end;j<N;j++){
                    temp -= number[j];
                }
                bw.write(temp+"\n");
            }
        }
        
        bw.flush();
    }
}