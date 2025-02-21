import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int L;
    static boolean[] mask;
    static int[] ingradient;
    static int[] calorie;
    static int max;
    
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 재료 개수
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리
            mask = new boolean[N];
            ingradient = new int[N];
            calorie = new int[N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                ingradient[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }
            max = 0;
            subset(0);
            bw.write("#"+t+" "+max+"\n");
        }
        bw.flush();
    }
    public static void subset(int cnt){
        if(cnt == N){
            int totalCalories = 0;
            int totalFlavor = 0;
            for(int i=0;i<N;i++){
                if(mask[i]){
                    totalCalories += calorie[i];
                    totalFlavor += ingradient[i];
                }
            }
            if(totalCalories<=L){
                max = Math.max(max,totalFlavor);
            }
            return;
        }

        mask[cnt] = true;
        subset(cnt+1);
        mask[cnt] = false;
        subset(cnt+1);
    }
}