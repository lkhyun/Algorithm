import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static long N;
    static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        if(N==0){
            bw.write("0");
        }else if(N==1){
            bw.write("1");
        }else{
            long[][] mat = {{1,1},{1,0}};
            bw.write(fibo(N-1,mat)[0][0]+"");
        }
        bw.close();
    }
    public static long[][] fibo(long cur, long[][] mat){
        if(cur==1) return mat;

        long[][] tmp = new long[2][2];
        tmp[0][0] = ((mat[0][0]*mat[0][0])%MOD + (mat[0][1]*mat[1][0])%MOD)%MOD;
        tmp[0][1] = ((mat[0][0]*mat[0][1])%MOD + (mat[0][1]*mat[1][1])%MOD)%MOD;
        tmp[1][0] = ((mat[1][0]*mat[0][0])%MOD + (mat[1][1]*mat[1][0])%MOD)%MOD;
        tmp[1][1] = ((mat[1][0]*mat[0][1])%MOD + (mat[1][1]*mat[1][1])%MOD)%MOD;
        if(cur%2==0){
            return fibo(cur/2,tmp);
        }else{
            long[][] extra = fibo(cur/2,tmp);
            long[][] result = new long[2][2];
            result[0][0] = ((extra[0][0]*mat[0][0])%MOD + (extra[0][1]*mat[1][0])%MOD)%MOD;
            result[0][1] = ((extra[0][0]*mat[0][1])%MOD + (extra[0][1]*mat[1][1])%MOD)%MOD;
            result[1][0] = ((extra[1][0]*mat[0][0])%MOD + (extra[1][1]*mat[1][0])%MOD)%MOD;
            result[1][1] = ((extra[1][0]*mat[0][1])%MOD + (extra[1][1]*mat[1][1])%MOD)%MOD;
            return result;
        }
    }
}