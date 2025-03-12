import java.util.*;
import java.io.*;

public class Main {
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<Integer> s = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("add")){
                int x = Integer.parseInt(st.nextToken());
                s.add(x);
            }else if(cmd.equals("remove")){
                int x = Integer.parseInt(st.nextToken());
                s.remove(x);
            }else if(cmd.equals("check")){
                int x = Integer.parseInt(st.nextToken());
                if(s.contains(x)){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }else if(cmd.equals("toggle")){
                int x = Integer.parseInt(st.nextToken());
                if(s.contains(x)){
                    s.remove(x);
                }else{
                    s.add(x);
                }
            }else if(cmd.equals("all")){
                s.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
            }else if(cmd.equals("empty")){
                s.clear();
            }
        }
        System.out.println(sb.toString());
    }
}
