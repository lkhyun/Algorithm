import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            BigInteger numerator = BigInteger.ONE;
            BigInteger denominator = BigInteger.ONE;
            for(int i=1;i<=N;i++){
                numerator = numerator.multiply(BigInteger.valueOf(M-i+1));
                denominator = denominator.multiply(BigInteger.valueOf(i));;
            }
            System.out.println(numerator.divide(denominator));
        }

    }
}
