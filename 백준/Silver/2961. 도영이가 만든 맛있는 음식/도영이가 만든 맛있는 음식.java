import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] S; //신맛
    static int[] B; //쓴맛
    static boolean[] mask;
    static int min;
    
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];
        mask = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
        subset(0);
        bw.write(min+"");
        bw.flush();
    }
    public static void subset(int cnt){
        if(cnt == N){
            int totalS = 1;
            int totalB = 0;
            for(int i=0;i<N;i++){
                if(mask[i]){
                    totalS *= S[i];
                    totalB += B[i];
                }
            }
            if(totalB != 0){
                min = Math.min(min,Math.abs(totalS-totalB));
            }
            return;
        }

        mask[cnt] = true;
        subset(cnt+1);
        mask[cnt] = false;
        subset(cnt+1);
    }

}