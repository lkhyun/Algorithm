import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        double[] expectation = new double[N+1];

        for(int i=1;i<=N;i++){
            for(int k=1;k<=6;k++){
                if(i-k >=0){
                    expectation[i] += expectation[i-k];
                }
            }
            expectation[i] = 1+(expectation[i]/6);
        }
        bw.write(expectation[N]+"");
        bw.flush();
    }
}