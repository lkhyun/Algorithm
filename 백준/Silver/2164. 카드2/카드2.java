import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int temp = 2;
        if(N == 1){bw.write("1"); bw.flush(); return;}
        else{ // 그려보니까 2의 제곱수면 그대로 나오고 아니면 N보다 작고 가장 큰 2의 제곱수와의 차이에 2를 곱한게 나옴.
            while(temp*2 <= N){
                temp*=2;
            }
        }
        if(temp==N){
            bw.write(String.valueOf(N));
        }else{
            bw.write(String.valueOf((N-temp)*2));
        }
        bw.flush();
    }
}