import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
    static int N;
    static int n1 = 1;
    static int n2 = 0;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        if(N==0){bw.write(0+"");}
        else if(N==1){bw.write(1+"");}
        else{
            bw.write(recursive(2)+"");
        }
        bw.flush();
    }
    public static int recursive(int depth){
        if(depth == N){
            return n1+n2;
        }
        int temp = n1;
        n1 = n1+n2;
        n2 = temp;
        return recursive(depth+1);
    }
}
