import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[] arr;
    static List<Integer> selected = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(0);
        bw.close();
    }
    public static void permutation(int depth) throws Exception{
        if(depth == M){
            for(int i:selected){
                bw.write(i+" ");
            }
            bw.write("\n");
            return;
        } 
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                selected.add(arr[i]);
                permutation(depth+1);
                selected.remove(selected.size()-1);
                visited[i] = false;
            }
        }
    }
}