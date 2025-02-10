import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        while(!str.isEmpty()){
            char[] ch = str.toCharArray();
            boolean flag = true;
            for(int i=0;i<ch.length/2;i++){
                if(ch[i]!=ch[ch.length-1-i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }
            str = br.readLine();
            if(str.equals("0")){break;}
        }
        bw.flush();
    }
}
