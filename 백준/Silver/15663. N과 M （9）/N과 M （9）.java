import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N,M;
    static int[] arr;
    static List<Integer> list;
    static Set<String> set;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        list = new ArrayList<>();
        set = new TreeSet<>((a,b) -> {
            String[] tokens = a.trim().split(" ");
            String[] tokens2 = b.trim().split(" ");
            for(int i=0; i<tokens.length; i++){
                if(tokens[i].equals(tokens2[i])){
                    continue;
                }
                return Integer.compare(Integer.parseInt(tokens[i]), Integer.parseInt(tokens2[i]));
            }
            return 0;
        });
        backtracking(0);
        for(String s :set){
            bw.write(s+"\n");
        }
        bw.close();
    }
    public static void backtracking(int depth) throws Exception {
        if(depth == M) {
            StringBuilder sb = new StringBuilder();
            for(int i : list) {
               sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                list.add(arr[i]);
                visited[i] = true;
                backtracking(depth+1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
