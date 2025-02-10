import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int g = gcd(A, B);
        bw.write(g+"\n");
        bw.write(A*B/g+"\n");
        bw.flush();
    }
    static int gcd(int a,int b){
        int r=0;
        while(b!=0){
            r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}
