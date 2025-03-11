import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int cur = K-1;
        sb.append(arr[cur]);
        visited[cur] = true;

        int cnt = 0;
        for(int i=1;i<N;i++){
            cnt = K;
            while(cnt!=0){
                cur = (cur+1)%N;
                if(!visited[cur]){
                    cnt--;
                }
            }
            sb.append(", "+arr[cur]);
            visited[cur] = true;
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}
