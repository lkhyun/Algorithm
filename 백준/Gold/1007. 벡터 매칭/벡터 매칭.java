import java.io.*;
import java.util.*;

public class Main {
    static int N, half;
    static int[] x;
    static int[] y;
    static long totalX, totalY;
    static double best;
    
    public static void main(String[] args) throws IOException {
        // BufferedReader를 이용하여 빠른 입력을 처리합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine().trim());
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
            sb.append(String.format("%.12f\n", best));
        }
        System.out.print(sb);
    }
    
    // index : 현재 고려 중인 점의 인덱스
    // count : 지금까지 선택한 점의 개수
    // curX, curY : 지금까지 선택한 점들의 x, y 좌표의 합
    static void dfs(int index, int count, long curX, long curY) {
        // 기저 조건: N/2개의 점을 선택한 경우
        if (count == half) {
            // 선택한 점들의 합으로부터 최종 벡터 합 계산: 2*(cur) - (total)
            long diffX = 2 * curX - totalX;
            long diffY = 2 * curY - totalY;
            double length = Math.sqrt(diffX * diffX + diffY * diffY);
            best = Math.min(best, length);
            return;
        }
        
        // 남은 점이 부족하면 더 이상 진행할 수 없음
        if (index >= N || (N - index) < (half - count))
            return;
        
        // 현재 점 선택: count 증가, curX, curY에 현재 점 추가
        dfs(index + 1, count + 1, curX + x[index], curY + y[index]);
        // 현재 점 선택하지 않음: 다음 인덱스로 넘어감
        dfs(index + 1, count, curX, curY);
    }
}
