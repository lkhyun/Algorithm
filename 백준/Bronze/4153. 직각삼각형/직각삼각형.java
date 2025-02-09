import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A;
        int B;
        int C;
        do{
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(A==0 && B==0 && C==0){break;}
            if(A>B && A>C){
                if(A*A == B*B+C*C){
                    bw.write("right\n");
                }else{
                    bw.write("wrong\n");
                }
            }else if(B>A && B>C){
                if(B*B == A*A+C*C){
                    bw.write("right\n");
                }else{
                    bw.write("wrong\n");
                }
            }else if(C>A && C>B){
                if(C*C == A*A+B*B){
                    bw.write("right\n");
                }else{
                    bw.write("wrong\n");
                }
            }
            st = new StringTokenizer(br.readLine());
        }while(st.hasMoreTokens());
        bw.flush();
    }
}
