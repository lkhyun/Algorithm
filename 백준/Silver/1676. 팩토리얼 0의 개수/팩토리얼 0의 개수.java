import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int two = 0;
        int five = 0;
        for(int i=1;i<=N;i++){
            int temp = i;
            while(temp%2==0){
                temp /= 2;
                two++;
            }
            while(temp%5==0){
                temp /= 5;
                five++;
            }
        }
        bw.write(String.valueOf(Math.min(two,five)));
        bw.flush();
    }
}