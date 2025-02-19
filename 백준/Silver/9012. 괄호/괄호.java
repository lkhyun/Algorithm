import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T;t++) {
            String str = br.readLine();
            ArrayDeque<Character> stk = new ArrayDeque<>(str.length());
            for(int i=0;i<str.length();i++){
                if(stk.size()==0){
                    stk.push(str.charAt(i));
                    continue;
                }
                if(stk.peek() == '('){
                    if(str.charAt(i) == ')'){
                        stk.poll();
                        continue;
                    }else{
                        stk.push(str.charAt(i));
                    }
                }else{
                    break;
                }
            }
            if(stk.size()==0){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }
        bw.flush();
    }    
}