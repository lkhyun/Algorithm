import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        int cur = 1;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=1;i<=N;i++){
            int target = Integer.parseInt(br.readLine());
            if(cur > target){
                if(stk.peek() == target){
                    sb.append("-\n");
                    stk.poll();
                }else{
                    flag = true;
                }
            }else if(cur<target){
                while(cur<=target){
                    stk.push(cur++);
                    sb.append("+\n");
                }
                stk.poll();
                sb.append("-\n");
            }else{
                sb.append("+\n");
                sb.append("-\n");
                cur++;
            }
        }
        if(flag==true){
            System.out.println("NO");
        }else{
            System.out.println(sb.toString());
        }
    }
}
