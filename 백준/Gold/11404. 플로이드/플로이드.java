import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        city = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(city[from][to] == 0){
                city[from][to] = cost;
            }else{
                city[from][to] = Math.min(city[from][to],cost);
            }
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(i == j){
                        continue;
                    }
                    if(city[i][k] != 0 && city[k][j] != 0){
                        if(city[i][j] == 0){
                            city[i][j] = city[i][k] + city[k][j];
                        }else{
                            city[i][j] = Math.min(city[i][j],city[i][k] + city[k][j]);
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bw.write(city[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
