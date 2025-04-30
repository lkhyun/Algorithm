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

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Set<Integer> tempSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tempSet.add(Integer.parseInt(st.nextToken()));
        }
        Object[] temp = tempSet.toArray();
        arr = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(temp[i]));
        }
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
        backtracking(0,0);
        for(String s :set){
            bw.write(s+"\n");
        }
        bw.close();
    }
    public static void backtracking(int depth,int start) throws Exception {
        if(depth == M) {
            StringBuilder sb = new StringBuilder();
            for(int i : list) {
               sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for(int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            backtracking(depth+1,i);
            list.remove(list.size()-1);
        }
    }
}
