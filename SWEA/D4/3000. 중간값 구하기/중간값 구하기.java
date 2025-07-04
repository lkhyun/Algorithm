import java.util.*;
import java.io.*;

public class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
            maxHeap.offer(M);

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                maxHeap.offer(a);
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(b);
                minHeap.offer(maxHeap.poll());
                if(minHeap.size() > maxHeap.size()){
                    maxHeap.offer(minHeap.poll());
                }
                ans += maxHeap.peek();
                ans %= 20171109;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(ans).append("\n");
            bw.write(sb.toString());
        }
        bw.close();
    }
}