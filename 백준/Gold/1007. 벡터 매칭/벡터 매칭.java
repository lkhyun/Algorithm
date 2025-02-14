import java.io.*;
import java.util.*;

public class Main {
    static int N, half;
    static int[] x;
    static int[] y;
    static long totalX, totalY;
    static double best;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            half = N / 2;
            x = new int[N];
            y = new int[N];
            totalX = 0;
            totalY = 0;
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
                totalX += x[i];
                totalY += y[i];
            }
            
            best = Double.MAX_VALUE;
            dfs(0, 0, 0, 0);
            sb.append(String.format("%f\n", best));
        }
        System.out.print(sb);
    }
    static void dfs(int index, int count, long curX, long curY) {
        if (count == half) {
            // 선택한 점들의 합으로부터 최종 벡터 합 계산: 2*(cur) - (total)
            long diffX = 2 * curX - totalX;
            long diffY = 2 * curY - totalY;
            double length = Math.sqrt(diffX * diffX + diffY * diffY);
            best = Math.min(best, length);
            return;
        }
       
        if (index >= N || (N - index) < (half - count))//범위를 넘거나 선택해야 하는 점 개수만큼 남아있지 않을때
            return;
        
        dfs(index + 1, count + 1, curX + x[index], curY + y[index]);// 현재 점 선택
        dfs(index + 1, count, curX, curY);// 현재 점 선택x
    }
}
