import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long A,B,C;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        bw.write(oper(A,B)+"");
        bw.close();
    }
    public static long oper(long a, long b){
        if(b == 1){
            return a%C;
        }
        if(b == 0){
            return 1;
        }
        if(b % 2 == 0){
            return oper((a*a)%C,b/2);
        }else{
            return (oper((a*a)%C,b/2) * a)%C;
        }
    }
}
